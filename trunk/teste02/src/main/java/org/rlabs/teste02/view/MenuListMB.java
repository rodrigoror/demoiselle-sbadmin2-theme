package org.rlabs.teste02.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.rlabs.teste02.business.MenuBC;
import org.rlabs.teste02.domain.Menu;

@ViewController
@NextView("pretty:/menu/#{bean.menu_id}")
@PreviousView("pretty:/menu/list")
@Join(path="/menu/list", to="/menu_list.jsf")
public class MenuListMB extends AbstractListPageBean<Menu, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MenuBC menuBC;
	
	@Override
	protected List<Menu> handleResultList() {
		return this.menuBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				menuBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}
	
	public String getActive(){
		return "active";
	}

}