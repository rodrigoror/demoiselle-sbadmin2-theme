package org.rlabs.teste02.exception;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.security.AuthorizationException;

public class NaoAutorizadoException extends AuthorizationException{

	private static final long serialVersionUID = 1L;
	@Inject
	private Logger logger;
	
	public NaoAutorizadoException(String mensagem) {
		super(mensagem);
		logger.info("NaoAutorizadoException Mensagem: "+mensagem);
	}

}
