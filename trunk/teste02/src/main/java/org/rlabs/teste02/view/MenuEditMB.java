package org.rlabs.teste02.view;

import java.util.Map;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.Parameter;
import org.rlabs.teste02.business.MenuBC;
import org.rlabs.teste02.domain.Menu;
import org.rlabs.teste02.util.IconsUtil;

@ViewController
@PreviousView("/menu/list")
@Join(path="/menu/#{bean.menu_id}", to="/menu_edit.jsf")
public class MenuEditMB extends AbstractEditPageBean<Menu, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MenuBC menuBC;
	
	@Override
	@Transactional
	public String delete() {
		this.menuBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.menuBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.menuBC.update(getBean());
		return getPreviousView();
	}
	
	
	@Override
	protected Menu handleLoad(Long id) {
		return this.menuBC.load(id);
	}
	
	/**
	 * Pegando as classes
	 * @return
	 */
	public Map<String,String> getClasses(){
		return IconsUtil.getWebApplicationIcons();
	}

}