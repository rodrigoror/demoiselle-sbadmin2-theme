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
	
	public String getActive(){
		return "active";
	}
	
	//TODO Verificar se o menu possue submenu para que serja possivel criar o submenu
	public Boolean isExists(){
		return true;
	}
}