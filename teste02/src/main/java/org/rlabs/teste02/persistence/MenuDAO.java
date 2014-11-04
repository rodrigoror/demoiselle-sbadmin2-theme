package org.rlabs.teste02.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.rlabs.teste02.domain.Menu;

@PersistenceController
public class MenuDAO extends JPACrud<Menu, Long> {

	private static final long serialVersionUID = 1L;
	

}
