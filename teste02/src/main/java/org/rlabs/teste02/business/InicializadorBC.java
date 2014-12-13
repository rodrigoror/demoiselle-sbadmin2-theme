/**
 * 
 */
package org.rlabs.teste02.business;

import javax.inject.Inject;

import org.rlabs.teste02.config.Teste02Config;
import org.rlabs.teste02.domain.Bookmark;
import org.rlabs.teste02.domain.Menu;
import org.rlabs.teste02.domain.SubMenu;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;


/**
 * @author rodrigo.ramos
 */
@BusinessController
public class InicializadorBC {
	
	@Inject
	private Logger logger;
	
	@Inject
	private Teste02Config sistemaConfig;
	
	@Inject
	private BookmarkBC bookmarkBC;
	
	@Inject
	private MenuBC menuBC;
	
	@Inject
	private SubMenuBC subMenuBC;
	
	/**
	 * Faz carga inicial de dados
	 */
	@Startup
	@Transactional
	public void onLoadDados(){
		// Logger do modo da aplicacao
		if (sistemaConfig.isModoDebugger()) {
			logger.info("--- InicializadorBC: Sistema está em modo debugger ---");
			this.onLoadBookmarks();
			this.onLoadMenu();
			this.onLoadSubMenu();
			this.onLoadCompany();
			this.onLoadPerfil();
			this.onLoadUsersLogin();
			this.onLoadLog();
		} else {
			logger.info("--- InicializadorBC: Sistema NÃO está em modo debugger ---");
		}
	}
	
	private void onLoadBookmarks() {
		
		Bookmark bookmark;
		bookmark = new Bookmark();
		bookmark.setLink( "http://www.frameworkdemoiselle.gov.br");
		bookmark.setDescription("Demoiselle Portal");
		bookmarkBC.insert(bookmark);
		
		bookmarkBC.insert(new Bookmark("Demoiselle SourceForge", "http://sf.net/projects/demoiselle"));
		bookmarkBC.insert(new Bookmark("Twitter", "http://twitter.frameworkdemoiselle.gov.br"));
		bookmarkBC.insert(new Bookmark("Blog", "http://blog.frameworkdemoiselle.gov.br"));
		bookmarkBC.insert(new Bookmark("Wiki", "http://wiki.frameworkdemoiselle.gov.br"));
		bookmarkBC.insert(new Bookmark("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br"));
		bookmarkBC.insert(new Bookmark("Forum", "http://forum.frameworkdemoiselle.gov.br"));
		bookmarkBC.insert(new Bookmark("SVN", "http://svn.frameworkdemoiselle.gov.br"));
		bookmarkBC.insert(new Bookmark("Maven", "http://repository.frameworkdemoiselle.gov.br"));
		bookmarkBC.insert(new Bookmark("Downloads", "http://download.frameworkdemoiselle.gov.br"));
	}
	
	private void onLoadMenu(){
		if (menuBC.findAll().isEmpty()) {
			//insert(new Menu("Classe", "Link","Permissao","Nome","Parent"));
			Menu menu;
			
			menu = new Menu();
			menu.setMenu_classe("fa fa-dashboard fa-fw");
			menu.setMenu_link("index.jsf");
			menu.setMenu_permissao("");
			menu.setMenu_nome("Dashboard");
			menu.setMenu_parent("_parent");
			menuBC.insert(menu);
			
			menuBC.insert(new Menu("fa fa-table fa-fw", "index.jsf","","Importar Propostas","_parent"));
			menuBC.insert(new Menu("fa fa-edit fa-fw", "index.jsf","","Timeline","_parent"));
			menuBC.insert(new Menu("fa fa-wrench fa-fw", "index.jsf","","Finanças","_parent"));
			menuBC.insert(new Menu("fa fa-sitemap fa-fw", "index.jsf","","Cadastros","_parent"));
			menuBC.insert(new Menu("fa fa-files-o fa-fw", "index.jsf","","E-mail","_parent"));
			menuBC.insert(new Menu("fa fa-table fa-fw", "bookmark_list.jsf","","Bookmark","_parent"));
			menuBC.insert(new Menu("fa fa-table fa-fw", "menu_list.jsf","","Menus","_parent"));
			menuBC.insert(new Menu("fa fa-table fa-fw", "submenu_list.jsf","","SubMenus","_parent"));
		}
	}
	
	private void onLoadSubMenu(){
		if (subMenuBC.findAll().isEmpty()) {
			Menu menu;
			menu = menuBC.load(1L);
			subMenuBC.insert(new SubMenu("teste.html","","SubMenu01","_parent",menu)); 
			
			menu = menuBC.load(2L);
			subMenuBC.insert(new SubMenu("teste.html","","SubMenu02","_blank",menu)); 
		}
	}
	
	private void onLoadCompany(){
		
	}
	
	private void onLoadPerfil(){
		
	}

	private void onLoadUsersLogin(){
		
	}
	
	private void onLoadLog(){
		
	}
	

}
