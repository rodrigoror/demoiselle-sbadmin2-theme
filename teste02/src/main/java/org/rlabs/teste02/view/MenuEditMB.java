package org.rlabs.teste02.view;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.MenuBC;
import org.rlabs.teste02.domain.Menu;

@ViewController
@PreviousView("./menu_list.jsf")
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
	
	public List<String> getClasses(){
		List<String> retorno = new ArrayList<String>();
		
		retorno.add("fa fa-dashboard fa-fw");
		retorno.add("fa fa-bar-chart-o fa-fw");
		retorno.add("fa fa-table fa-fw");
		retorno.add("fa fa-edit fa-fw");
		retorno.add("fa fa-wrench fa-fw");
		retorno.add("fa fa-sitemap fa-fw");
		retorno.add("fa fa-files-o fa-fw");
		
		return retorno;
	}

}