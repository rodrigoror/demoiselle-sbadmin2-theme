package org.rlabs.teste02.business;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;


import org.rlabs.teste02.domain.CompanyEnd;
import org.rlabs.teste02.persistence.CompanyEndDAO;
import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;
import org.rlabs.teste02.view.CredenciaisMB;
import org.slf4j.Logger;

@BusinessController
public class CompanyEndBC extends DelegateCrud<CompanyEnd, Long, CompanyEndDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private LogBC logBC;
	
	@Inject
	private Logger logger;
	
	@Inject
	private CredenciaisMB credenciaisMB;
	
	/**
	 * Insere um CompanyEnd inserindo Log
	 * @param bean CompanyEnd
	 */
	@Override
	@Transactional
	public CompanyEnd insert(CompanyEnd bean) {
		
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.COMPANYEND, 
				bean.getLog());

		return bean;
	}
}
