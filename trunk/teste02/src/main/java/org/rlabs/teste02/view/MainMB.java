/**
 * 
 */
package org.rlabs.teste02.view;


import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.rlabs.teste02.business.MenuBC;
import org.rlabs.teste02.business.SubMenuBC;
import org.rlabs.teste02.config.Teste02Config;
import org.rlabs.teste02.domain.Menu;
import org.rlabs.teste02.domain.SubMenu;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;

/**
 * @author rodrigo.ramos
 */
@ViewController
public class MainMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;
	
	private String ERR = "ERR";

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private MenuBC menuBC;
	
	@Inject
	private SubMenuBC subMenuBC;
	
	/**
	 * Retorna o nome da tela clicado no menu
	 * @return String
	 */
	public String getPageHeader(){
		String retorno = ERR;
		String currentPage = facesContext.getViewRoot().getViewId();
		
		currentPage = currentPage.substring(1);
		int tamanho = currentPage.length();
		currentPage = currentPage.substring(0, tamanho - 6);
		
		List<Menu> lstMenu = menuBC.findAll();
		List<SubMenu> lstSMenu = subMenuBC.findAll();
		String linkMenu = ERR;
		String linkSMenu = ERR;
		
		for (Menu menu : lstMenu){
			
			linkMenu = menu.getMenu_link();
			int tam = linkMenu.length();
			
			linkMenu = linkMenu.substring(0, tam - 4);
			if (currentPage.equals(linkMenu)){
				retorno = menu.getMenu_nome();
			}
		}
		if (retorno == ERR){
			for (SubMenu smenu : lstSMenu){
				
				linkSMenu = smenu.getSmen_link();
				int tam = linkSMenu.length();
				
				linkSMenu = linkSMenu.substring(0, tam - 4);
				if (currentPage.equals(linkSMenu)){
					retorno = smenu.getSmen_nome();
				}
			}
		}
		
		
		return retorno;
	}
	@Inject
	private Teste02Config sistemaConfig;
	
	public String getBase(){
		FacesContext context = FacesContext.getCurrentInstance();  
		  
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();  
		  
		String urlAtual = request.getRequestURL().toString();  
		
		String retorno = urlAtual;
		if (sistemaConfig.isModoDebugger()){
			retorno = "http://localhost:8080/teste02/";
		}
		return retorno;
	}
	
}
