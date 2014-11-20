package org.rlabs.teste02.business;

import java.util.Date;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.security.User;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import org.rlabs.teste02.domain.Log;
import org.rlabs.teste02.persistence.LogDAO;
import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;
import org.slf4j.Logger;

/**
 * Classe para auxilio nas operacoes de auditoria
 * @author fernando.camilo
 */
@BusinessController
public class LogBC extends DelegateCrud<Log, Long, LogDAO> {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private Logger logger;
	
	private static final String USUARIO_SISTEMA = "sistema";
	
	
	/**
	 * Insere registro de auditoria com os dados informados, assumindo a data atual
	 * @return 
	 */
	@Override
	@Transactional
	public Log insert(Log bean) {
		bean.setLog_data(new Date());
		return this.getDelegate().insert(bean);
	}
	
	
	/**
	 * Insere registro de auditoria com os dados informados, assumindo o login do usuario logado, e a data atual
	 * @param acao
	 * @param entidade
	 * @param dados
	 */
	@Transactional
	public void insert(AcaoEnum acao, EntidadeEnum entidade, String dados) {
		Log log = new Log();
		log.setLog_acao(acao);
		log.setLog_entidade(entidade);
		log.setLog_usuario(getLoginUsuarioLogado());
		log.setLog_dados(dados);
		log.setLog_data(new Date());
		this.getDelegate().insert(log);
	}
	

	/**
	 * Insere registro de auditoria com os dados informados, assumindo a data atual
	 * @param acao
	 * @param entidade
	 * @param loginUsuario
	 * @param dados
	 */
	@Transactional
	public void insert(AcaoEnum acao, EntidadeEnum entidade, String loginUsuario, String dados) {
		Log log = new Log();
		log.setLog_acao(acao);
		log.setLog_entidade(entidade);
		log.setLog_usuario(loginUsuario);
		log.setLog_dados(dados);
		log.setLog_data(new Date());
		this.getDelegate().insert(log);
	}


	@Override
	@Deprecated
	@Transactional
	public void delete(Long id) {
		this.getDelegate().delete(id);
	}


	@Override
	@Deprecated
	@Transactional
	public Log update(Log bean) {
		return this.getDelegate().update(bean);
	}
	
	
	/**
	 * Retorna o login do usuario logado, ou "sistema" se nao houver usuario logado
	 * @return
	 */
	private String getLoginUsuarioLogado() {
		String login;
		try {
			User user = securityContext.getUser();
			if (user != null) {
				login = (String)user.getAttribute("login");
			} else {
				logger.warn("Usuario nao logado. Retornando login como SISTEMA.");
				login = USUARIO_SISTEMA;
			}
		} catch (RuntimeException e) {
			logger.warn("Erro ao capturar o usuario logado. Retornando login como SISTEMA.");
			login = USUARIO_SISTEMA;
		}
		return login;
	}
	
}
