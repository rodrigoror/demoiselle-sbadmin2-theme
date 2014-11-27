package org.rlabs.teste02.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.SubMenuBC;
import org.rlabs.teste02.domain.SubMenu;

@ViewController
@PreviousView("./subMenu_list.jsf")
public class SubMenuEditMB extends AbstractEditPageBean<SubMenu, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SubMenuBC subMenuBC;
	
	public Boolean getActive(){
		return subMenuBC.getActive();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.subMenuBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.subMenuBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.subMenuBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected SubMenu handleLoad(Long id) {
		return this.subMenuBC.load(id);
	}

}