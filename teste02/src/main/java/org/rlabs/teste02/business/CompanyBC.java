package org.rlabs.teste02.business;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import org.rlabs.teste02.domain.Company;
import org.rlabs.teste02.persistence.CompanyDAO;
import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;
import org.rlabs.teste02.view.CredenciaisMB;
import org.slf4j.Logger;

@BusinessController
public class CompanyBC extends DelegateCrud<Company, Long, CompanyDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private LogBC logBC;
	
	@Inject
	private Logger logger;
	
	@Inject
	private CredenciaisMB credenciaisMB;
	
	/**
	 * Insere um Company inserindo Log
	 * @param bean Company
	 */
	@Override
	@Transactional
	public Company insert(Company bean) {
		
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.COMPANY, 
				bean.getLog());

		return bean;
	}
}
