package org.rlabs.teste02.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.rlabs.teste02.domain.Users;

@PersistenceController
public class UsersDAO extends JPACrud<Users, Long> {

	private static final long serialVersionUID = 1L;
	

}
