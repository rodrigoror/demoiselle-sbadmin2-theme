package org.rlabs.teste02.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import org.rlabs.teste02.domain.Menu;
import org.rlabs.teste02.persistence.MenuDAO;

@BusinessController
public class MenuBC extends DelegateCrud<Menu, Long, MenuDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
