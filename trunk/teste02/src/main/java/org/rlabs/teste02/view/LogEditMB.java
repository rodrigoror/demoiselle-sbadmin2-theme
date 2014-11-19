package org.rlabs.teste02.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.LogBC;
import org.rlabs.teste02.domain.Log;

@ViewController
@PreviousView("./log_list.jsf")
public class LogEditMB extends AbstractEditPageBean<Log, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private LogBC logBC;
	
	@Override
	@Transactional
	public String delete() {
		this.logBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.logBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.logBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.logBC.load(getId()));
	}

}