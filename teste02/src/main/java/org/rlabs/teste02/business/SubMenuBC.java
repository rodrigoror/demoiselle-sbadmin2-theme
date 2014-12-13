package org.rlabs.teste02.business;


import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

import org.rlabs.teste02.domain.SubMenu;

import org.rlabs.teste02.persistence.SubMenuDAO;
import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;

import org.rlabs.teste02.view.CredenciaisMB;
import org.slf4j.Logger;

@BusinessController
public class SubMenuBC extends DelegateCrud<SubMenu, Long, SubMenuDAO> {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CredenciaisMB credenciaisMB;
	
	@Inject
	private ResourceBundle resourceBundle;
	
	@Inject
	private LogBC logBC;
	
	@Inject
	private Logger logger;
	
	public Boolean getActive() {
		return this.getDelegate().getActiveList();
	}
	
	/**
	 * Insere um usuario
	 * @param bean Usuario
	 * @return 
	 */
	@Override
	@Transactional
	public SubMenu insert(SubMenu bean) {
		
		//Ajustes:
		bean.setSmen_link(bean.getSmen_link().toLowerCase());
		bean.setSmen_permissao(bean.getSmen_permissao().toUpperCase());//User_senha(SenhaUtil.sha256(bean.getUser_senha()));
		//Insere:
		this.getDelegate().insert(bean);
		//Auditoria:
		logBC.insert(AcaoEnum.CADASTROU, 
				EntidadeEnum.SUBMENU, 
				bean.toString());
		return bean;
	}
}
