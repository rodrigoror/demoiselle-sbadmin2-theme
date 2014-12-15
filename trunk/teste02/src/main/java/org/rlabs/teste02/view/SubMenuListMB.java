package org.rlabs.teste02.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.SubMenuBC;
import org.rlabs.teste02.domain.SubMenu;

@ViewController
@NextView("./subMenu_edit.jsf")
@PreviousView("./subMenu_list.jsf")
public class SubMenuListMB extends AbstractListPageBean<SubMenu, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SubMenuBC subMenuBC;
	
	public List<SubMenu> getSubMenu(Long menu_id){
		return this.subMenuBC.getSubMenu(menu_id);
	}
	
	@Override
	protected List<SubMenu> handleResultList() {
		return this.subMenuBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				subMenuBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getActive(Long menu_id){
		String retorno = "active"; 
		
		//TODO Verificar se o cara logado clicou no menu e inserir active apenas para o menu que ele clicou
		//talvez usar session para gravar.
		if(this.subMenuBC.getSubMenu(menu_id).isEmpty()){
			retorno = "#";
		}
		return retorno;
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean isExists(Long menu_id){
		Boolean retorno = true;
		if(this.subMenuBC.getSubMenu(menu_id).isEmpty()){
			retorno = false;
		}
		return retorno;
	}
}