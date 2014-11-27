package org.rlabs.teste02.business;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import org.rlabs.teste02.domain.Menu;
import org.rlabs.teste02.domain.SubMenu;
import org.rlabs.teste02.persistence.SubMenuDAO;

@BusinessController
public class SubMenuBC extends DelegateCrud<SubMenu, Long, SubMenuDAO> {
	
	private static final long serialVersionUID = 1L;

	public Boolean getActive() {
		return this.getDelegate().getActiveList();
	}
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new SubMenu("00","teste.html","ROOT","Teste","_blank",new Menu("4","TesteMenu.html","ROOT","Teste do Menu","_parent"))); 
		}
	}
}
