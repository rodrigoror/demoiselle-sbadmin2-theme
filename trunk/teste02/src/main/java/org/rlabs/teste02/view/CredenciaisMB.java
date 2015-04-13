package org.rlabs.teste02.view;

import javax.inject.Inject;

import org.rlabs.teste02.exception.CustomException;
import org.rlabs.teste02.exception.Excecao;
import org.rlabs.teste02.security.Credenciais;
import org.rlabs.teste02.util.LoggerUtil;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;

/**
 * @author  rodrigo.ramos
 */
@ViewController
public class CredenciaisMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;
	
	@Inject
	private LoggerUtil logger;

	@Inject
	private SecurityContext securityContext;

	/**
	 * @uml.property  name="credenciais"
	 * @uml.associationEnd  
	 */
	@Inject
	private Credenciais credenciais;

	/**
	 * @uml.property  name="customException"
	 * @uml.associationEnd  
	 */
	@Inject
	private CustomException customException;

	public void login() {
		logger.info("login()");
		try {
			securityContext.login();
		} catch (RuntimeException e) {
			logger.error("login()-RuntimeException: "+e.getMessage());
			messageContext.add(e.getMessage(), SeverityType.ERROR, "");
		}
	}

	public void logout() {
		logger.info("logout()");
		if (securityContext.getUser().getId() != null) {
			logger.info("logout() securityContext.logout()");
			securityContext.logout();
		} else {
			logger.error("logout(): idUser:"+securityContext.getUser().getId());
			customException.adicionarMensagem("{mensagem.credenciais.logout.erro}");
		}
	}

	@ExceptionHandler
	public void tratador(CustomException exception) {
		logger.info("tratador()");
		for (Excecao excecao : exception.getExcecoes()) {
			logger.error("Exception() "+excecao.getMensagem());
			messageContext.add(excecao.getMensagem(), SeverityType.ERROR, excecao.getParametros());
		}
		exception.getExcecoes().clear();
	}
	
	/**
	 * Verifica se o usuário logado possui um dos papéis informados. Usado no menu.xhtml.
	 * @param papeis (string vazia, ou string com os papéis separados por vírgula)
	 * @return
	 */
	public boolean getVerificarPapel(String papeis) {
		if (securityContext.getUser() != null) {
			if (!papeis.trim().equals("")) {
				return papeis.contains((CharSequence)securityContext.getUser().getAttribute("papel"));
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Métodos Get's and Set's
	 * @return
	 */
	public Credenciais getCredenciais() {
		return credenciais;
	}
	
	/**
	 * @param credenciais
	 */
	public void setCredenciais(Credenciais credenciais) {
		this.credenciais = credenciais;
	}
}
