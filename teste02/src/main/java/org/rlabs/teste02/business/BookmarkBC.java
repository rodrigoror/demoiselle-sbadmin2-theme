package org.rlabs.teste02.business;


import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import org.rlabs.teste02.domain.Bookmark;
import org.rlabs.teste02.persistence.BookmarkDAO;
import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;
import org.rlabs.teste02.view.CredenciaisMB;
import org.slf4j.Logger;

@BusinessController
public class BookmarkBC extends DelegateCrud<Bookmark, Long, BookmarkDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LogBC logBC;
	
	@Inject
	private Logger logger;
	
	@Inject
	private CredenciaisMB credenciaisMB;
	
	/**
	 * Insere um Bookmark inserindo Log
	 * @param bean Bookmark
	 */
	@Override
	@Transactional
	public Bookmark insert(Bookmark bean) {
		
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.BOOKMARK, 
				bean.getLog());

		return bean;
	}
}
