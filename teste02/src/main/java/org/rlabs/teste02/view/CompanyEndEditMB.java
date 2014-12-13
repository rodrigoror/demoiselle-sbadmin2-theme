package org.rlabs.teste02.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.CompanyEndBC;
import org.rlabs.teste02.domain.CompanyEnd;

@ViewController
@PreviousView("./companyEnd_list.jsf")
public class CompanyEndEditMB extends AbstractEditPageBean<CompanyEnd, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CompanyEndBC companyEndBC;
	
	@Override
	@Transactional
	public String delete() {
		this.companyEndBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.companyEndBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.companyEndBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected CompanyEnd handleLoad(Long id) {
		return this.companyEndBC.load(getId());
	}

}