package org.rlabs.teste02.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.LogBC;
import org.rlabs.teste02.domain.Log;

@ViewController
@NextView("./log_edit.jsf")
@PreviousView("./log_list.jsf")
public class LogListMB extends AbstractListPageBean<Log, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private LogBC logBC;
	
	@Override
	protected List<Log> handleResultList() {
		return this.logBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				logBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}