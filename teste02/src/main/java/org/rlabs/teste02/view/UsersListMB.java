package org.rlabs.teste02.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.UsersBC;
import org.rlabs.teste02.domain.Users;

@ViewController
@NextView("./users_edit.jsf")
@PreviousView("./users_list.jsf")
public class UsersListMB extends AbstractListPageBean<Users, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsersBC usersBC;
	
	@Override
	protected List<Users> handleResultList() {
		return this.usersBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				usersBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}