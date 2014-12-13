package org.rlabs.teste02.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.rlabs.teste02.domain.Perfil;

@PersistenceController
public class PerfilDAO extends JPACrud<Perfil, Long> {

	private static final long serialVersionUID = 1L;
	

}
