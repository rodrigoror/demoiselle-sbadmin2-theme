package org.rlabs.teste02.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.rlabs.teste02.business.UsersBC;
import org.rlabs.teste02.domain.Users;

import br.gov.frameworkdemoiselle.util.Beans;

@FacesConverter (forClass = Users.class)
public class UsersConverter   implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {

		if (string != null && !string.trim().isEmpty()) {
			Long id = Long.parseLong(string);
			return userBC().load(id);
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {

		if (objeto != null && objeto instanceof Users) {
			Users usuario = (Users) objeto;
			if (usuario.getUser_id() != null) {
				return usuario.getUser_id().toString();
			}
		}
		return null;
	}

	private UsersBC userBC() {
		return Beans.getReference(UsersBC.class);
	}
}
