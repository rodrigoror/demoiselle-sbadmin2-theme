package org.rlabs.teste02.util;

import java.io.Serializable;
import javax.inject.Inject;

import org.rlabs.teste02.config.Teste02Config;
import org.slf4j.Logger;

public class LoggerUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Teste02Config t02c;
	
	@Inject
	private Logger logger;
	
	public void debug(String text){
		if(t02c.isModoDebugger())logger.debug(text);
	}
	public void warn(String text){
		if(t02c.isModoDebugger())logger.warn(text);
	}
	public void error(String text){
		if(t02c.isModoDebugger())logger.error(text);
	}
	public void info(String text){
		if(t02c.isModoDebugger())logger.info(text);
	}
	public void log(String text){
		logger.info(text);
	}
}
