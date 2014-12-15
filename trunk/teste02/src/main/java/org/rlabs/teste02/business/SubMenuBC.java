package org.rlabs.teste02.business;


import java.util.List;

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
	
	/**
	 * 
	 * @return
	 */
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
	
	/**
	 * Lista os submenus referentes a determinado menu
	 * @param menu_id
	 * @return
	 */
	public List<SubMenu> getSubMenu(Long menu_id) {
		return this.getDelegate().getSubMenu(menu_id);
	}
}
