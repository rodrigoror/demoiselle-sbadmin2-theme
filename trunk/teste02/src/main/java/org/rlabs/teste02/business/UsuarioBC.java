/*package org.rlabs.teste02.business;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.sp.sjc.fadenp2.domain.Equipe;
import br.gov.sp.sjc.fadenp2.domain.Usuario;
import br.gov.sp.sjc.fadenp2.exception.BusinessException;
import br.gov.sp.sjc.fadenp2.persistence.EquipeDAO;
import br.gov.sp.sjc.fadenp2.persistence.UsuarioDAO;
import br.gov.sp.sjc.fadenp2.util.AcaoEnum;
import br.gov.sp.sjc.fadenp2.util.EntidadeEnum;
import br.gov.sp.sjc.fadenp2.util.SenhaUtil;
import org.rlabs.teste02.view.CredenciaisMB;

*//**
 * Classe BC que controla o usuario
 * @author  rodrigo.ramos
 *//*
@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EquipeDAO equipeDAO;
	
	@Inject
	private CredenciaisMB credenciaisMB;
	
	@Inject
	private ResourceBundle resourceBundle;
	
	@Inject
	private LogBC logBC;
	
	@Inject
	private Logger logger;
	
	*//**
	 * Insere um usuario
	 * @param bean Usuario
	 *//*
	@Override
	@Transactional
	public void insert(org.rlabs.teste02.domain.Usuario bean) {
		//Validacoes:
		if (this.getDelegate().getByLogin(bean.getUsua_login().toLowerCase(), false) != null) {
			throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.existe"));
		}
		checkSenhaObedecePolitica(bean.getUsua_senha());
		//Ajustes:
		bean.setUsua_login(bean.getUsua_login().toLowerCase());
		bean.setUsua_senha(SenhaUtil.md5(bean.getUsua_senha()));
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.USUARIO, 
				bean.getUsua_usrcadastro(), 
				bean.getDadosAuditoria());
	}

	*//**
	 * Insere um usuario
	 * @param bean Usuario
	 * @param confirmacaoSenha Confirmacao da senha
	 *//*
	@Transactional
	public void insert(Usuario bean, String confirmacaoSenha) {
		//Validacoes:
		if (this.getDelegate().getByLogin(bean.getUsua_login().toLowerCase(), false) != null) {
			throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.existe"));
		}
		if (!bean.getUsua_senha().equals(confirmacaoSenha)) {
			throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.senha"));
		}
		checkSenhaObedecePolitica(bean.getUsua_senha());
		//Ajustes:
		bean.setUsua_login(bean.getUsua_login().toLowerCase());
		bean.setUsua_senha(SenhaUtil.md5(bean.getUsua_senha()));
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.USUARIO, 
				bean.getUsua_usrcadastro(), 
				bean.getDadosAuditoria());
	}
	
	*//**
	 * Altera um usuario
	 * @param bean Usuario
	 *//*
	@Transactional
	@Override
	public void update(Usuario bean) {
		//Validacoes:
		Usuario usuario = this.getDelegate().getByLogin(bean.getUsua_login().toLowerCase(), false);
		if (usuario != null) {
			if (!usuario.getUsua_id().equals(bean.getUsua_id())) {
				throw new BusinessException(resourceBundle.getString("mensagem.registronaopodesercriado", "Outro usuário com o mesmo e-mail"));
			}
		}
		//Atualiza:
		this.getDelegate().update(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.ALTEROU, 
				EntidadeEnum.USUARIO, 
				bean.getDadosAuditoria());
	}
	
	*//**
	 * Exclui um usuario
	 * @param id ID do usuario
	 *//*
	@Transactional
	@Override
	public void delete(Long id) {
		//Validacoes:
		checkUsuarioPodeSerExcluido(id);
		//Auditoria:
		Usuario usuario = this.load(id);
		logBC.insert(AcaoEnum.EXCLUIU, 
				EntidadeEnum.USUARIO, 
				usuario.getDadosAuditoria());
		//Exclusao:
		this.getDelegate().delete(id);
	}
	
	*//**
	 * Usado para autenticacao do usuario, atraves de login e senha (SOMENTE ATIVOS)
	 * @param login
	 * @param senha (sem MD5)
	 * @return Usuario
	 *//*
	@Transactional
	public Usuario getByLogin(String login, String senha) {
		Usuario usuario = null;
		usuario = this.getDelegate().getByLogin(login, SenhaUtil.md5(senha));
		return usuario;
	}
	
	*//**
	 * Usado para autenticacao do usuario (SOMENTE ATIVOS), para busca apenas por login
	 * @param login
	 * @return Usuario
	 *//*
	@Transactional
	public Usuario getByLogin(String login) {
		Usuario usuario = null;
		usuario = this.getDelegate().getByLogin(login, true);
		return usuario;
	}
	
	*//**
	 * Retorna uma lista dos usuarios ativos
	 * @return Lista de usuarios ativos
	 *//*
	@Transactional
	public List<Usuario> getAtivos(){
		return this.getDelegate().getAtivos();
		
	}
	
	*//**
	 * Se quem esta logado e ADMINISTRADOR, retorna lista com todos os usuarios, senao retorna uma lista como todos que NaO sao administradores.
	 * @return Lista de usuarios
	 *//*
	@Transactional
	public List<Usuario>getByPerfil(){
		if(isAdministrator()){
			return findAll();
		}else{
			return this.getDelegate().findExceptAdm();
		}
	}
	
	*//**
	 * Retorna uma lista de usuarios (SOMENTE ATIVOS) pelo codigo do perfil (ex: COORDENADOR)
	 * @param codigoPerfil
	 * @return Lista de usuarios
	 *//*
	@Transactional
	public List<Usuario>getByPerfil(String codigoPerfil){
		return this.getDelegate().getByPerfil(codigoPerfil);
	}	

	
	*//**
	 * Retorna uma lista dos GERENTES e SUPERVISORES ativos
	 * @return
	 *//*
	@Transactional
	public List<Usuario> getGerentesESupervisores() {
		return this.getDelegate().getGerentesESupervisores();
	}
	
	
	*//**
	 * Atualiza a senha de um usuario (SOMENTE ATIVOS)
	 * @param login
	 * @param senhaAtual
	 * @param novaSenha
	 * @param repeticaoNovaSenha
	 *//*
	@Transactional
	public void setNovaSenha(String login, String senhaAtual, String novaSenha, String repeticaoNovaSenha) {
		Usuario usuario;
		usuario = this.getDelegate().getByLogin(login, SenhaUtil.md5(senhaAtual));
		if (usuario != null) {
			if (novaSenha.equals(repeticaoNovaSenha)) {
				checkSenhaObedecePolitica(novaSenha);
				//Altera:
				usuario.setUsua_senha(SenhaUtil.md5(novaSenha));
				this.getDelegate().update(usuario);
				//Auditoria:
				logBC.insert(AcaoEnum.ALTEROU, 
						EntidadeEnum.USUARIO, 
						usuario.getDadosAuditoria());
			} else {
				throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.senha"));
			}
		} else {
			throw new BusinessException(resourceBundle.getString("usuariobc.insert.erro.senhaatual"));
		}
	}
	
	
	*//**
	 * Forcando nova senha para o usuario encontrado (SOMENTE ATIVOS).
	 * Valido somente para usuarios ativos.
	 * @param login
	 * @param novaSenha
	 *//*
	@Transactional
	public void setForceNovaSenha(String login, String novaSenha) {
		Usuario usuario;
		usuario = this.getDelegate().getByLogin(login,true);
		if (usuario != null) {
			checkSenhaObedecePolitica(novaSenha);
			//Altera:
			usuario.setUsua_senha(SenhaUtil.md5(novaSenha));
			this.getDelegate().update(usuario);
			//Auditoria:
			logBC.insert(AcaoEnum.ALTEROU, 
					EntidadeEnum.USUARIO, 
					usuario.getDadosAuditoria());
		} else {
			throw new BusinessException(resourceBundle.getString("usuario.mensagem.inativo"));
		}
	}
	
	*//**
	 *  Testa se uma senha obedece a politica de senhas da aplicacao.
	 *  Se nao obedecer, joga uma BusinessException
	 * @param senha
	 *//*
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
	
	*//**
	 * Retorna se uma string contem pelo menos uma letra
	 * @param valor
	 * @return
	 *//*
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

	*//**
	 *  Retorna se uma string contem pelo menos um numero
	 *  @return boolean
	 *//*
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
	
	*//**
	 * Retorna se o usuario logado atualmente e administrador
	 * @return
	 *//*
	public boolean isAdministrator() {
		boolean retorno = false;
		if (credenciaisMB.getVerificarPapel("ADMINISTRADOR")){
				retorno =  true;
		}
		return retorno;
	}
	
	*//**
	 * Verifica se o usuario pode ser excluido, resultando em BusinessException se nao puder
	 * @param id
	 *//*
	private void checkUsuarioPodeSerExcluido(Long id) {
		List<Equipe> equipes;
		// Verifica se nao esta como coordenador de equipe de alguma equipe
		equipes = equipeDAO.findByCoordenadorEquipe(id);
		if (!(equipes.isEmpty()))
			throw new BusinessException(resourceBundle.getString("mensagem.registronaopodeserexcluido", "Usuário", "equipes"));
		equipes.clear();
		// Verifica se nao esta como coordenador gerencial de alguma equipe
		equipes = equipeDAO.findByCoordenadorGerencial(id);
		if (!(equipes.isEmpty()))
			throw new BusinessException(resourceBundle.getString("mensagem.registronaopodeserexcluido", "Usuário", "equipes"));
	}
}
*/