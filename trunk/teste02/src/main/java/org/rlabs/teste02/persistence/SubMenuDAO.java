package org.rlabs.teste02.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.rlabs.teste02.domain.SubMenu;

@PersistenceController
public class SubMenuDAO extends JPACrud<SubMenu, Long> {

	private static final long serialVersionUID = 1L;

	public Boolean getActiveList() {
		return true;
	}
	

}
