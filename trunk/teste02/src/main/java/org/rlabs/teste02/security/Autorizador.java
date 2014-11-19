package org.rlabs.teste02.security;

//import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.SecurityContext;

/**
 * @author  rodrigo.ramos
 */
//@Alternative
public class Autorizador implements Authorizer{
	private static final long serialVersionUID = 1L;

	@Inject
	private SecurityContext securityContext;
	
	@Override
	public boolean hasPermission(String arg0, String arg1) {
		return true;
	}
	
	// Responde pela anotacao @RequiredRole
	@Override
	public boolean hasRole(String role) {
		boolean autorizado = false;
		
		if (securityContext.isLoggedIn()) {
			if (securityContext.getUser().getAttribute("papel").equals(role)) {
				autorizado = true;
			}
		} 

		return autorizado;
	}
}
