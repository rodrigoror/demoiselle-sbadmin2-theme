package org.rlabs.teste02.business;

import java.util.List;

import javax.inject.Inject;


import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

import org.rlabs.teste02.domain.Users;
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
public class UsersBC extends DelegateCrud<Users, Long, UsersDAO> {
	
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
	public Users insert(Users bean) {
		//Validacoes:
		if (this.getDelegate().getByLogin(bean.getUser_login().toLowerCase(), false) != null) {
			throw new BusinessException("Erro: Login Já Existe");//throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.existe"));
		}
		checkSenhaObedecePolitica(bean.getUser_senha());
		//Ajustes:
		bean.setUser_login(bean.getUser_login().toLowerCase());
		bean.setUser_senha(/*SenhaUtil.sha256(*/bean.getUser_senha())/*)*/;
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.USERS, 
				bean.getLog());
		return bean;
	}

	/**
	 * Insere um usuario
	 * @param bean Usuario
	 * @param confirmacaoSenha Confirmacao da senha
	 */
	@Transactional
	public void insert(Users bean, String confirmacaoSenha) {
		//Validacoes:
		if (this.getDelegate().getByLogin(bean.getUser_login().toLowerCase(), false) != null) {
			throw new BusinessException("Já Existe");//throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.existe"));
		}
		if (!bean.getUser_senha().equals(confirmacaoSenha)) {
			throw new BusinessException("Senha Incorreta");//throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.senha"));
		}
		checkSenhaObedecePolitica(bean.getUser_senha());
		//Ajustes:
		bean.setUser_login(bean.getUser_login().toLowerCase());
		bean.setUser_senha(/*SenhaUtil.sha256(*/bean.getUser_senha())/*)*/;//TODO corrigir a criptografia
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.USERS, 
				bean.getUser_ipUpdate(), 
				bean.getLog());
	}
	
	/**
	 * Altera um usuario
	 * @param bean Usuario
	 * @return 
	 */
	@Transactional
	@Override
	public Users update(Users bean) {
		//Validacoes:
		Users usuario = this.getDelegate().getByLogin(bean.getUser_login().toLowerCase(), false);
		if (usuario != null) {
			if (!usuario.getUser_id().equals(bean.getUser_id())) {
				throw new BusinessException("Outro usuário com o mesmo e-mail");//throw new BusinessException(resourceBundle.getString("mensagem.registronaopodesercriado", "Outro usuário com o mesmo e-mail"));
			}
		}
		//Atualiza:
		this.getDelegate().update(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.ALTEROU, 
				EntidadeEnum.USERS, 
				bean.getLog());
		return bean;
	}
	
	/**
	 * Exclui um usuario
	 * @param id ID do usuario
	 */
	@Transactional
	@Override
	public void delete(Long id) {
		//verifica se pode ser excluido
		checkUsuarioPodeSerExcluido(id);
		
		//Auditoria:
		Users usuario = this.load(id);
		logBC.insert(AcaoEnum.EXCLUIU, 
				EntidadeEnum.USERS, 
				usuario.getLog());
		
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
	public Users getByLogin(String login, String senha) {
		Users usuario = null;
		usuario = this.getDelegate().getByLogin(login,/* SenhaUtil.sha256(*/senha/*)*/);
		return usuario;
	}
	
	/**
	 * Usado para autenticacao do usuario (SOMENTE ATIVOS), para busca apenas por login
	 * @param login
	 * @return Usuario
	 */
	@Transactional
	public Users getByLogin(String login) {
		Users usuario = null;
		usuario = this.getDelegate().getByLogin(login, true);
		return usuario;
	}
	
	/**
	 * Retorna uma lista dos usuarios ativos
	 * @return Lista de usuarios ativos
	 */
	@Transactional
	public List<Users> getAtivos(){
		return this.getDelegate().getAtivos();
	}
	
	/**
	 * Se quem esta logado for ADMINISTRADOR, 
	 * retorna lista com todos os usuarios, 
	 * senao retorna uma lista como todos que NAO sao administradores.
	 * @return Lista de usuarios
	 */
	@Transactional
	public List<Users>getByPerfil(){
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
	public List<Users>getByPerfil(String codigoPerfil){
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
		Users usuario;
		usuario = this.getDelegate().getByLogin(login, SenhaUtil.sha256(senhaAtual));
		if (usuario != null) {
			if (novaSenha.equals(repeticaoNovaSenha)) {
				checkSenhaObedecePolitica(novaSenha);
				//Altera:
				usuario.setUser_senha(/*SenhaUtil.sha256(*/novaSenha/*)*/);
				this.getDelegate().update(usuario);
				//Auditoria:
				logBC.insert(AcaoEnum.ALTEROU, 
						EntidadeEnum.USERS, 
						usuario.getLog());
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
		Users usuario;
		usuario = this.getDelegate().getByLogin(login,true);
		if (usuario != null) {
			checkSenhaObedecePolitica(novaSenha);
			//Altera:
			usuario.setUser_senha(/*SenhaUtil.sha256(*/novaSenha)/*)*/;
			this.getDelegate().update(usuario);
			//Auditoria:
			logBC.insert(AcaoEnum.ALTEROU, 
					EntidadeEnum.USERS, 
					usuario.getLog());
		} else {
			throw new BusinessException("Usuário Inativo");//throw new BusinessException(resourceBundle.getString("usuario.mensagem.inativo"));
		}
	}
	
	/**
	 *  Testa se uma senha obedece a politica de senhas da aplicacao.
	 *  Se nao obedecer, joga uma BusinessException
	 * @param senha
	 */
	private void checkSenhaObedecePolitica(String senha) {
		if (senha.length() >= 6) {
			if (senha.length() <= 20) {
				if (getStringContemLetra(senha)) {
					if (getStringContemNumero(senha)) {
						logger.info(" --- Senha obedece a política");
					} else {
						throw new BusinessException("Não obedece a politica");//throw new BusinessException(resourceBundle.getString("usuariobc.politica.letranumero"));
					}
				} else {
					throw new BusinessException("Não Obedece a Politica");//throw new BusinessException(resourceBundle.getString("usuariobc.politica.letranumero"));
				}
			} else {
				throw new BusinessException("Ultrapassou o maximo");//throw new BusinessException(resourceBundle.getString("usuariobc.politica.caracteresmax"));
			}
		} else {
			throw new BusinessException("Nao Ultrapassou o minimo");//throw new BusinessException(resourceBundle.getString("usuariobc.politica.caracteresmin"));
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
		}
		return retorno;
	}
	
	/**
	 * Verifica se o usuario pode ser excluido, resultando em BusinessException se nao puder
	 * @param id
	 */
	private void checkUsuarioPodeSerExcluido(Long id) {
		Users users1 = this.load(id);
		Long IDComp = users1.getUser_company().getComp_id();
		List<Users> lstUsers = this.getDelegate().getByCompany(IDComp);
		if (lstUsers.size()>1){
			//POde Deletar
		}else{
			throw new BusinessException("A empresa deve possuir ao menos 1 usuário");
		}
		/*List<Equipe> equipes;
		// Verifica se nao esta como coordenador de equipe de alguma equipe
		equipes = equipeDAO.findByCoordenadorEquipe(id);
		if (!(equipes.isEmpty()))
			throw new BusinessException(resourceBundle.getString("mensagem.registronaopodeserexcluido", "Usuário", "equipes"));
		equipes.clear();
		// Verifica se nao esta como coordenador gerencial de alguma equipe
		equipes = equipeDAO.findByCoordenadorGerencial(id);
		if (!(equipes.isEmpty()))
			throw new BusinessException(resourceBundle.getString("mensagem.registronaopodeserexcluido", "Usuário", "equipes"));
		*/
	}
	
}