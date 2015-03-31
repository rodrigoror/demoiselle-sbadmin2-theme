/**
 * 
 */
package org.rlabs.teste02.business;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.rlabs.teste02.config.Teste02Config;
import org.rlabs.teste02.domain.Bookmark;
import org.rlabs.teste02.domain.Company;
import org.rlabs.teste02.domain.Log;
import org.rlabs.teste02.domain.Menu;
import org.rlabs.teste02.domain.Perfil;
import org.rlabs.teste02.domain.SubMenu;
import org.rlabs.teste02.domain.Users;
import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;
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
		
	@Inject
	private PerfilBC perfilBC;
	
	@Inject
	private CompanyBC companyBC;
	
	@Inject
	private UsersBC usersBC;
	
	@Inject
	private LogBC logBC;
	
	//*
	
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
			this.onLoadUsers();
			this.onLoadLog();
		} else {
			logger.info("--- InicializadorBC: Sistema NÃO está em modo debugger ---");
		}
	}
	
	private void onLoadBookmarks() {
		if (bookmarkBC.findAll().isEmpty()) {
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
			
			menuBC.insert(new Menu("fa fa-cloud-upload fa-fw", "index.jsf?#","","Importar Propostas","_parent"));
			menuBC.insert(new Menu("fa fa-edit fa-fw", "index.jsf?#","","Timeline","_parent"));
			menuBC.insert(new Menu("fa fa-money fa-fw", "index.jsf?#","","Finanças","_parent"));
			menuBC.insert(new Menu("fa fa-archive fa-fw", "index.jsf?#","","Cadastros","_parent"));
			menuBC.insert(new Menu("fa fa-envelope fa-fw", "index.jsf?#","","E-mail","_parent"));
			menuBC.insert(new Menu("fa fa-bookmark fa-fw", "bookmark_list.jsf","","Bookmark","_parent"));
			menuBC.insert(new Menu("fa fa-cogs fa-fw", "index.jsf?#","","Configs","_parent"));
			
		}
	}
	
	private void onLoadSubMenu(){
		if (subMenuBC.findAll().isEmpty()) {
			List<Menu> lstMenu = menuBC.findAll();
			
			Menu menu;
			
			menu = lstMenu.get(4);
			subMenuBC.insert(new SubMenu("users_list.jsf","","Usuários","_parent",menu)); 
			subMenuBC.insert(new SubMenu("company_list.jsf","","Companys","_parent",menu)); 
			subMenuBC.insert(new SubMenu("perfil_list.jsf","","Perfis","_parent",menu)); 
			
			menu = lstMenu.get(7);//configuração (Definitivo)
			subMenuBC.insert(new SubMenu("menu_list.jsf","","Menus","_parent",menu));
			subMenuBC.insert(new SubMenu("submenu_list.jsf","","SubMenus","_parent",menu));
		}
	}
	
	
	private void onLoadPerfil(){
		if (perfilBC.findAll().isEmpty()) {
			Perfil perfil;
			perfil = new Perfil();
			perfil.setPerf_ativo(true);
			perfil.setPerf_codigo("ROOT");
			perfil.setPerf_descricao("Root");
			perfil.setPerf_excluido(false);
			perfil.setPerf_dtUpdate(new Date());
			perfil.setPerf_ipUpdate("192.168.0.1");//sistema
			perfil.setPerf_loginUpdate("sistema@rlabs.com");
			perfilBC.insert(perfil);
			
			perfil = new Perfil();
			perfil.setPerf_ativo(true);
			perfil.setPerf_codigo("ROOT-ATENDIMENTO");
			perfil.setPerf_descricao("Root - Atendimento");
			perfil.setPerf_excluido(false);
			perfil.setPerf_dtUpdate(new Date());
			perfil.setPerf_ipUpdate("192.168.0.1");//sistema
			perfil.setPerf_loginUpdate("sistema@rlabs.com");
			perfilBC.insert(perfil);
			
			perfil = new Perfil();
			perfil.setPerf_ativo(true);
			perfil.setPerf_codigo("DIRETORES");
			perfil.setPerf_descricao("Diretores");
			perfil.setPerf_excluido(false);
			perfil.setPerf_dtUpdate(new Date());
			perfil.setPerf_ipUpdate("192.168.0.1");//sistema
			perfil.setPerf_loginUpdate("sistema@rlabs.com");
			perfilBC.insert(perfil);
			
			perfil = new Perfil();
			perfil.setPerf_ativo(true);
			perfil.setPerf_codigo("GERENTES");
			perfil.setPerf_descricao("Gerentes");
			perfil.setPerf_excluido(false);
			perfil.setPerf_dtUpdate(new Date());
			perfil.setPerf_ipUpdate("192.168.0.1");//sistema
			perfil.setPerf_loginUpdate("sistema@rlabs.com");
			perfilBC.insert(perfil);
			
			perfil = new Perfil();
			perfil.setPerf_ativo(true);
			perfil.setPerf_codigo("CORRETORES");
			perfil.setPerf_descricao("Corretores");
			perfil.setPerf_excluido(false);
			perfil.setPerf_dtUpdate(new Date());
			perfil.setPerf_ipUpdate("192.168.0.1");//sistema
			perfil.setPerf_loginUpdate("sistema@rlabs.com");
			perfilBC.insert(perfil);
		}
	}
	
	private void onLoadCompany(){
		if(companyBC.findAll().isEmpty()){
			Company cia = new Company();
			cia.setComp_ativo(true);
			cia.setComp_cnpj("56.758.210/0001-06");
			cia.setComp_dtUpdate(new Date());
			cia.setComp_excluido(false);
			cia.setComp_fone("1200000000");
			cia.setComp_ipUpdate("192.168.0.1");
			cia.setComp_loginUpdate("sistema@rlabs.com");
			cia.setComp_nomeFantasia("Empresa Padrão");
			cia.setComp_pais("Brasil");
			cia.setComp_razaoSocial("Empresa Padrão S/A");
			cia.setComp_responsavel("Root of Debian");
			//cia.setCompanyEnds(companyEnds);
			companyBC.insert(cia);
		}
	}
	
	

	private void onLoadUsers(){
		if (usersBC.findAll().isEmpty()) {
			List<Company> lstCompany = companyBC.findAll();
			List<Perfil> lstPerfil = perfilBC.findAll();
			
			Users users;
			users = new Users();
			Company user_company = lstCompany.get(0);
			Perfil user_perfil = lstPerfil.get(0);
			
			/*users.setUser_login("contato@rlabs.com");
			users.setUser_cpf("12345678909");
			users.setUser_susep("01234");
			users.setUser_senha("root#1745$ROOT");
			users.setUser_ativo(true);
			users.setUser_nome("Root of Debian RoD");
			users.setUser_excluido(false);
			users.setUser_company(user_company);
			users.setUser_dtUpdate(new Date());
			users.setUser_ipUpdate("192.168.0.1");
			users.setUser_loginUpdate("sistema@rlabs.com");
			users.setUser_perfil(user_perfil);
			usersBC.insert(users);
			
			users.setUser_login("contato2@rlabs.com");
			users.setUser_cpf("22738854826");
			users.setUser_susep("56789");
			users.setUser_senha("root#1745$ROOT");
			users.setUser_ativo(true);
			users.setUser_nome("Riot of Games");
			users.setUser_excluido(false);
			users.setUser_company(user_company);
			users.setUser_dtUpdate(new Date());
			users.setUser_ipUpdate("192.168.0.1");
			users.setUser_loginUpdate("sistema@rlabs.com");
			users.setUser_perfil(user_perfil);
			usersBC.insert(users);*/
		}
	}
	
	private void onLoadLog(){
		if (logBC.findAll().isEmpty()) {
			Log log = new Log();
			log.setLog_acao(AcaoEnum.CADASTROU);
			log.setLog_entidade(EntidadeEnum.INICIALIZADOR);
			log.setLog_usuario("Sistema");
			log.setLog_dados("SE VC VER ESTE CAMPO, QUER DIZER QUE O SISTEMA NÃO INSERIU NENHUMA OUTRA CLASSE NO INICIALIZADORBC");
			log.setLog_data(new Date());
			logBC.insert(log);
		}
	}
	

}
