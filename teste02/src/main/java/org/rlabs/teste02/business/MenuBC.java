package org.rlabs.teste02.business;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import org.rlabs.teste02.domain.Menu;
import org.rlabs.teste02.persistence.MenuDAO;

@BusinessController
public class MenuBC extends DelegateCrud<Menu, Long, MenuDAO> {
	
	private static final long serialVersionUID = 1L;
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			//insert(new Menu("Classe", "Link","Permissao","Nome","Parent"));
			insert(new Menu("fa fa-dashboard fa-fw", "index.jsf","ALL","Dashboard","_parent"));
			insert(new Menu("fa fa-bar-chart-o fa-fw", "index.jsf","ALL","Charts","_parent"));
			insert(new Menu("fa fa-table fa-fw", "index.jsf","ALL","Tables","_parent"));
			insert(new Menu("fa fa-edit fa-fw", "index.jsf","ALL","Forms","_parent"));
			insert(new Menu("fa fa-wrench fa-fw", "index.jsf","ALL","UI Elements","_parent"));
			insert(new Menu("fa fa-sitemap fa-fw", "index.jsf","ALL","Multi-Level","_parent"));
			insert(new Menu("fa fa-files-o fa-fw", "index.jsf","ALL"," Sample Pages","_parent"));
			insert(new Menu("fa fa-table fa-fw", "bookmark_list.jsf","ALL","Bookmarks","_parent"));
			insert(new Menu("fa fa-table fa-fw", "menu_list.jsf","ALL","Menus","_parent"));

		}
	}
}