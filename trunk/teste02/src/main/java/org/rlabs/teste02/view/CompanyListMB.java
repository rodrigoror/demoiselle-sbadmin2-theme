package org.rlabs.teste02.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.CompanyBC;
import org.rlabs.teste02.domain.Company;

@ViewController
@NextView("./company_edit.jsf")
@PreviousView("./company_list.jsf")
public class CompanyListMB extends AbstractListPageBean<Company, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CompanyBC companyBC;
	
	@Override
	protected List<Company> handleResultList() {
		return this.companyBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				companyBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}