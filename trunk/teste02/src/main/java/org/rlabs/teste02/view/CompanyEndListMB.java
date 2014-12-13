package org.rlabs.teste02.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.CompanyEndBC;
import org.rlabs.teste02.domain.CompanyEnd;

@ViewController
@NextView("./companyEnd_edit.jsf")
@PreviousView("./companyEnd_list.jsf")
public class CompanyEndListMB extends AbstractListPageBean<CompanyEnd, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CompanyEndBC companyEndBC;
	
	@Override
	protected List<CompanyEnd> handleResultList() {
		return this.companyEndBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				companyEndBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}