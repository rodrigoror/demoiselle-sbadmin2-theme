package org.rlabs.teste02.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.UsersBC;
import org.rlabs.teste02.domain.Users;

@ViewController
@PreviousView("./users_list.jsf")
public class UsersEditMB extends AbstractEditPageBean<Users, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsersBC usersBC;
	
	@Override
	@Transactional
	public String delete() {
		this.usersBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.usersBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.usersBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.usersBC.load(getId()));
	}

}