package org.rlabs.teste02.business;


import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import org.rlabs.teste02.domain.SubMenu;
import org.rlabs.teste02.persistence.SubMenuDAO;

@BusinessController
public class SubMenuBC extends DelegateCrud<SubMenu, Long, SubMenuDAO> {
	
	private static final long serialVersionUID = 1L;

	public Boolean getActive() {
		return this.getDelegate().getActiveList();
	}
	
}
