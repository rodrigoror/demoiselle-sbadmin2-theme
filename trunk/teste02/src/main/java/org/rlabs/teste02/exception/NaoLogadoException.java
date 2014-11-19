package org.rlabs.teste02.exception;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.security.NotLoggedInException;

public class NaoLogadoException extends NotLoggedInException{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	
	public NaoLogadoException(String message) {
		
		super(message);
		logger.info("NaoLogadoException Mensagem: "+message);
		
	}

}
