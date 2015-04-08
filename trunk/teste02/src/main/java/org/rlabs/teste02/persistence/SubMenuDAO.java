package org.rlabs.teste02.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.rlabs.teste02.domain.SubMenu;

@PersistenceController
public class SubMenuDAO extends JPACrud<SubMenu, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public Boolean getActiveList() {
		return true;
	}

	public List<SubMenu> getSubMenu(Long menu_id) {
		String qr = "SELECT sm "
				+ "FROM SubMenu sm "
				+ "WHERE sm.smen_menu.menu_id = :pId";
		
		@SuppressWarnings("unchecked")
		List<SubMenu> retorno = em.createQuery(qr)
				.setParameter("pId", menu_id)
				.getResultList();
		
		return retorno;
	}
	

}
