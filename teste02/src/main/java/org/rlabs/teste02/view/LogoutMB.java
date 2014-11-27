package org.rlabs.teste02.view;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import org.rlabs.teste02.exception.BusinessException;

@ViewController
@PreviousView("./index.xhtml")
@NextView("./index.xhtml")
@RequiredRole({"ADMINISTRADOR", "COORDENADOR", "GERENTE", "ADMINISTRATIVO", "SUPERVISOR"})
public class LogoutMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MessageContext messageContext;
	
	@Inject
	private SecurityContext securityContext;

	@Inject
	private Logger logger;

	
	public String logout() {
		logger.info("logout()");
		try {
			securityContext.logout();
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		return this.getNextView();
	}
	
	
	@ExceptionHandler
	public void tratador(BusinessException ex) {
		messageContext.add(ex.getMessage(), SeverityType.ERROR, "");
	}

}
