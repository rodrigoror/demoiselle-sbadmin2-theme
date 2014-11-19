package org.rlabs.teste02.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import org.rlabs.teste02.domain.Log;
import org.rlabs.teste02.persistence.LogDAO;

@BusinessController
public class LogBC extends DelegateCrud<Log, Long, LogDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
