package org.rlabs.teste02.exception;

import javax.inject.Inject;
import org.rlabs.teste02.util.LoggerUtil;
import br.gov.frameworkdemoiselle.security.NotLoggedInException;

public class NaoLogadoException extends NotLoggedInException{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoggerUtil logger;
	
	public NaoLogadoException(String message) {
		
		super(message);
		logger.info("NaoLogadoException Mensagem: "+message);
		
	}

}
