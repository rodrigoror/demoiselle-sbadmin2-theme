package org.rlabs.teste02.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.CompanyBC;
import org.rlabs.teste02.domain.Company;

@ViewController
@PreviousView("./company_list.jsf")
public class CompanyEditMB extends AbstractEditPageBean<Company, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CompanyBC companyBC;
	
	@Override
	@Transactional
	public String delete() {
		this.companyBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.companyBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.companyBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected Company handleLoad(Long id) {
		return this.companyBC.load(getId());
	}



}