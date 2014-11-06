/**
 * 
 */
package org.rlabs.teste02.view;


import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.rlabs.teste02.business.MenuBC;
import org.rlabs.teste02.domain.Menu;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;

/**
 * @author rodrigo.ramos
 */
@ViewController
public class MainMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private MenuBC menuBC;
	
	public String getPageHeader(){
		String retorno = "";
		String currentPage = facesContext.getViewRoot().getViewId();
		
		currentPage = currentPage.substring(1);
		int tamanho = currentPage.length();
		currentPage = currentPage.substring(0, tamanho - 6);
		
		List<Menu> lstMenu = menuBC.findAll();
		String linkMenu = "";
		
		for (Menu menu : lstMenu){
			
			linkMenu = menu.getMenu_link();
			int tam = linkMenu.length();
			
			linkMenu = linkMenu.substring(0, tam - 4);
			if (currentPage.equals(linkMenu)){
				retorno = menu.getMenu_nome();
			}
		}
		
		return retorno;
	}
	
}
