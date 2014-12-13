package org.rlabs.teste02.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.rlabs.teste02.business.PerfilBC;
import org.rlabs.teste02.domain.Perfil;

@ViewController
@PreviousView("./perfil_list.jsf")
public class PerfilEditMB extends AbstractEditPageBean<Perfil, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PerfilBC perfilBC;
	
	@Override
	@Transactional
	public String delete() {
		this.perfilBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.perfilBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.perfilBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected Perfil handleLoad(Long id) {
		return this.perfilBC.load(getId());
	}

}