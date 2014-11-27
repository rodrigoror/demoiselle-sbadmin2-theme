package org.rlabs.teste02.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.frameworkdemoiselle.util.Beans;
import br.gov.sp.sjc.fadenp2.business.UsuarioBC;
import br.gov.sp.sjc.fadenp2.domain.Usuario;



@FacesConverter (forClass = Usuario.class)
public class UsuarioConverter  implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {

		if (string != null && !string.trim().isEmpty()) {
			Long id = Long.parseLong(string);
			return usuarioBC().load(id);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {

		if (objeto != null && objeto instanceof Usuario) {
			Usuario usuario = (Usuario) objeto;
			if (usuario.getUsua_id() != null) {
				return usuario.getUsua_id().toString();
			}
		}
		return null;
	}

	private UsuarioBC usuarioBC() {
		return Beans.getReference(UsuarioBC.class);
	}
}