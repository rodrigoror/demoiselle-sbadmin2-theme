package org.rlabs.teste02.business;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

import org.rlabs.teste02.domain.Company;
import org.rlabs.teste02.domain.Perfil;
import org.rlabs.teste02.domain.UsersLogin;
import org.rlabs.teste02.exception.BusinessException;
import org.rlabs.teste02.persistence.UsersDAO;
import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;
import org.rlabs.teste02.util.SenhaUtil;
import org.rlabs.teste02.view.CredenciaisMB;
import org.slf4j.Logger;

/**
 * Classe BC que controla o usuario
 * @author  rodrigoror@gmail.com
 */
@BusinessController
public class UsersBC extends DelegateCrud<UsersLogin, Long, UsersDAO> {
	
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private CredenciaisMB credenciaisMB;
	
	@Inject
	private ResourceBundle resourceBundle;
	
	@Inject
	private LogBC logBC;
	
	@Inject
	private Logger logger;
	
	/**
	 * Insere um usuario
	 * @param bean Usuario
	 * @return 
	 */
	@Override
	@Transactional
	public UsersLogin insert(UsersLogin bean) {
		//Validacoes:
		if (this.getDelegate().getByLogin(bean.getUser_login().toLowerCase(), false) != null) {
			throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.existe"));
		}
		checkSenhaObedecePolitica(bean.getUser_senha());
		//Ajustes:
		bean.setUser_login(bean.getUser_login().toLowerCase());
		bean.setUser_senha(SenhaUtil.sha256(bean.getUser_senha()));
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.USERS, 
				bean.getUser_ipUpdate(), 
				bean.getDadosAuditoria());
		return bean;
	}

	/**
	 * Insere um usuario
	 * @param bean Usuario
	 * @param confirmacaoSenha Confirmacao da senha
	 */
	@Transactional
	public void insert(UsersLogin bean, String confirmacaoSenha) {
		//Validacoes:
		if (this.getDelegate().getByLogin(bean.getUser_login().toLowerCase(), false) != null) {
			throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.existe"));
		}
		if (!bean.getUser_senha().equals(confirmacaoSenha)) {
			throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.senha"));
		}
		checkSenhaObedecePolitica(bean.getUser_senha());
		//Ajustes:
		bean.setUser_login(bean.getUser_login().toLowerCase());
		bean.setUser_senha(SenhaUtil.sha256(bean.getUser_senha()));
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.USERS, 
				bean.getUser_ipUpdate(), 
				bean.getDadosAuditoria());
	}
	
	/**
	 * Altera um usuario
	 * @param bean Usuario
	 * @return 
	 */
	@Transactional
	@Override
	public UsersLogin update(UsersLogin bean) {
		//Validacoes:
		UsersLogin usuario = this.getDelegate().getByLogin(bean.getUser_login().toLowerCase(), false);
		if (usuario != null) {
			if (!usuario.getUser_id().equals(bean.getUser_id())) {
				throw new BusinessException(resourceBundle.getString("mensagem.registronaopodesercriado", "Outro usuário com o mesmo e-mail"));
			}
		}
		//Atualiza:
		this.getDelegate().update(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.ALTEROU, 
				EntidadeEnum.USERS, 
				bean.getDadosAuditoria());
		return bean;
	}
	
	/**
	 * Exclui um usuario
	 * @param id ID do usuario
	 */
	@Transactional
	@Override
	public void delete(Long id) {
		//Auditoria:
		UsersLogin usuario = this.load(id);
		logBC.insert(AcaoEnum.EXCLUIU, 
				EntidadeEnum.USERS, 
				usuario.getDadosAuditoria());
		
		//Exclusao:
		//this.getDelegate().delete(id);
		usuario.setUser_excluido(true);
		this.getDelegate().update(usuario);
	}
	
	/**
	 * Usado para autenticacao do usuario, atraves de login e senha (SOMENTE ATIVOS)
	 * @param login
	 * @param senha (sem MD5)
	 * @return Usuario
	 */
	@Transactional
	public UsersLogin getByLogin(String login, String senha) {
		UsersLogin usuario = null;
		usuario = this.getDelegate().getByLogin(login, SenhaUtil.sha256(senha));
		return usuario;
	}
	
	/**
	 * Usado para autenticacao do usuario (SOMENTE ATIVOS), para busca apenas por login
	 * @param login
	 * @return Usuario
	 */
	@Transactional
	public UsersLogin getByLogin(String login) {
		UsersLogin usuario = null;
		usuario = this.getDelegate().getByLogin(login, true);
		return usuario;
	}
	
	/**
	 * Retorna uma lista dos usuarios ativos
	 * @return Lista de usuarios ativos
	 */
	@Transactional
	public List<UsersLogin> getAtivos(){
		return this.getDelegate().getAtivos();
	}
	
	/**
	 * Se quem esta logado for ADMINISTRADOR, 
	 * retorna lista com todos os usuarios, 
	 * senao retorna uma lista como todos que NAO sao administradores.
	 * @return Lista de usuarios
	 */
	@Transactional
	public List<UsersLogin>getByPerfil(){
		if(isAdministrator()){
			return findAll();
		}else{
			return this.getDelegate().findExceptAdm();
		}
	}
	
	/**
	 * Retorna uma lista de usuarios (SOMENTE ATIVOS) pelo codigo do perfil (ex: COORDENADOR)
	 * @param codigoPerfil
	 * @return Lista de usuarios
	 */
	@Transactional
	public List<UsersLogin>getByPerfil(String codigoPerfil){
		return this.getDelegate().getByPerfil(codigoPerfil);
	}	

	/**
	 * Atualiza a senha de um usuario (SOMENTE ATIVOS)
	 * @param login
	 * @param senhaAtual
	 * @param novaSenha
	 * @param repeticaoNovaSenha
	 */
	@Transactional
	public void setNovaSenha(String login, String senhaAtual, String novaSenha, String repeticaoNovaSenha) {
		UsersLogin usuario;
		usuario = this.getDelegate().getByLogin(login, SenhaUtil.sha256(senhaAtual));
		if (usuario != null) {
			if (novaSenha.equals(repeticaoNovaSenha)) {
				checkSenhaObedecePolitica(novaSenha);
				//Altera:
				usuario.setUser_senha(SenhaUtil.sha256(novaSenha));
				this.getDelegate().update(usuario);
				//Auditoria:
				logBC.insert(AcaoEnum.ALTEROU, 
						EntidadeEnum.USERS, 
						usuario.getDadosAuditoria());
			} else {
				throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.senha"));
			}
		} else {
			throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.senhaatual"));
		}
	}
	
	/**
	 * Forcando nova senha para o usuario encontrado (SOMENTE ATIVOS).
	 * Valido somente para usuarios ativos.
	 * @param login
	 * @param novaSenha
	 */
	@Transactional
	public void setForceNovaSenha(String login, String novaSenha) {
		UsersLogin usuario;
		usuario = this.getDelegate().getByLogin(login,true);
		if (usuario != null) {
			checkSenhaObedecePolitica(novaSenha);
			//Altera:
			usuario.setUser_senha(SenhaUtil.sha256(novaSenha));
			this.getDelegate().update(usuario);
			//Auditoria:
			logBC.insert(AcaoEnum.ALTEROU, 
					EntidadeEnum.USERS, 
					usuario.getDadosAuditoria());
		} else {
			throw new BusinessException(resourceBundle.getString("usuario.mensagem.inativo"));
		}
	}
	
	/**
	 *  Testa se uma senha obedece a politica de senhas da aplicacao.
	 *  Se nao obedecer, joga uma BusinessException
	 * @param senha
	 */
	private void checkSenhaObedecePolitica(String senha) {
		if (senha.length() >= 6) {
			if (senha.length() <= 10) {
				if (getStringContemLetra(senha)) {
					if (getStringContemNumero(senha)) {
						logger.info(" --- Senha obedece a política");
					} else {
						throw new BusinessException(resourceBundle.getString("usuariobc.politica.letranumero"));
					}
				} else {
					throw new BusinessException(resourceBundle.getString("usuariobc.politica.letranumero"));
				}
			} else {
				throw new BusinessException(resourceBundle.getString("usuariobc.politica.caracteresmax"));
			}
		} else {
			throw new BusinessException(resourceBundle.getString("usuariobc.politica.caracteresmin"));
		}
	}
	
	/**
	 * Retorna se uma string contem pelo menos uma letra
	 * @param valor
	 * @return
	 */
	private boolean getStringContemLetra(String valor) {
		String check = "abcdefghijklmnopqrstuvwxyz";
		boolean retorno = false;
		for (int i = 0; i <= valor.length() - 1; i++) {
			if (check.indexOf(valor.toLowerCase().charAt(i)) != -1) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}

	/**
	 *  Retorna se uma string contem pelo menos um numero
	 *  @return boolean
	 */
	private boolean getStringContemNumero(String valor) {
		String check = "0123456789";
		boolean retorno = false;
		for (int i = 0; i <= valor.length() - 1; i++) {
			if (check.indexOf(valor.charAt(i)) != -1) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}
	
	/**
	 * Retorna se o usuario logado atualmente e administrador
	 * @return
	 */
	public boolean isAdministrator() {
		boolean retorno = false;
		if (credenciaisMB.getVerificarPapel("ADMINISTRADOR")){
				retorno =  true;
		}/**/
		return retorno;
	}
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			//insert(new Menu("Classe", "Link","Permissao","Nome","Parent"));
			insert(new UsersLogin("root@gmail.com",
							"12345678909",
							"123456789",
							"10.0025038",
							"Usuário Root",
							"1239026900",true,false,"192.168.0.1","root@gmail.com",new Date(),
							new Perfil("Root","ROOT",true,false,"192.168.0.1","root@gmail.com",new Date()),
							new Company("56.758.210/0001-06","Razão Social","Nome Fantasia","Brasil","12999149812","José de Arimateia",true,false,"192.168.0.1","root@gmail.com",new Date())
							));
		}
	}
}
