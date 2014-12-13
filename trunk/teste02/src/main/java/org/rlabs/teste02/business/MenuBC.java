package org.rlabs.teste02.business;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import org.rlabs.teste02.domain.Menu;
import org.rlabs.teste02.persistence.MenuDAO;
import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;
import org.rlabs.teste02.view.CredenciaisMB;
import org.slf4j.Logger;

@BusinessController
public class MenuBC extends DelegateCrud<Menu, Long, MenuDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LogBC logBC;
	
	@Inject
	private Logger logger;
	
	@Inject
	private CredenciaisMB credenciaisMB;
	
	/**
	 * Insere um Menu inserindo Log
	 * @param bean Menu
	 */
	@Override
	@Transactional
	public Menu insert(Menu bean) {
		
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.MENU, 
				bean.getLog());

		return bean;
	}
}
