package org.rlabs.teste02.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import org.rlabs.teste02.domain.Perfil;
import org.rlabs.teste02.persistence.PerfilDAO;

@BusinessController
public class PerfilBC extends DelegateCrud<Perfil, Long, PerfilDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
