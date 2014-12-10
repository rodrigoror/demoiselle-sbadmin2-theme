package org.rlabs.teste02.security;


import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.rlabs.teste02.business.LogBC;
import org.rlabs.teste02.business.UsersBC;
import org.rlabs.teste02.domain.UsersLogin;
import org.rlabs.teste02.util.AcaoEnum;
import org.rlabs.teste02.util.EntidadeEnum;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;
/*import br.gov.sp.sjc.fadenp2.business.LogBC;
import br.gov.sp.sjc.fadenp2.business.UsuarioBC;
import br.gov.sp.sjc.fadenp2.domain.Usuario;
import br.gov.sp.sjc.fadenp2.util.AcaoEnum;
import br.gov.sp.sjc.fadenp2.util.EntidadeEnum;*/

/**
 * @author  rodrigo.ramos
 */
//@Alternative
public class Autenticador implements Authenticator{
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="credenciais"
	 * @uml.associationEnd  
	 */
	@Inject
	private Credenciais credenciais;

	/**
	 * @uml.property  name="usuarioBC"
	 * @uml.associationEnd  
	 */
	@Inject
	private UsersBC usuarioBC;
	
	@Inject
	private LogBC logBC;

	/**
	 * @uml.property  name="user"
	 * @uml.associationEnd  
	 */
	private MyUser user = null;
	
	/**/@Inject
	private Logger logger; 

	@Override
	public void authenticate() {

		UsersLogin usuario = usuarioBC.getByLogin(credenciais.getLogin(), credenciais.getSenha());
		if (usuario != null) {
			credenciais.setId(usuario.getUser_id());
			credenciais.setNome(usuario.getUser_nome());
			credenciais.setPapel(usuario.getUser_perfil().getPerf_codigo());
			credenciais.setSenha(null);
			//Auditoria:
			logBC.insert(AcaoEnum.LOGOU, EntidadeEnum.USERS, credenciais.getLogin(), "IP: " + getClientIP());
		} else {
			credenciais.clear();
			throw new RuntimeException("{mensagem.usuario.load.erro}");
		}

		//return autenticado;
	}

	/**
	 * @return
	 * @uml.property  name="user"
	 */
	@Override
	public User getUser() {
		if (credenciais != null) {
			if (credenciais.getLogin() != null) {
				user = new MyUser();
				user.setId(credenciais.getLogin());
				user.setAttribute("id", credenciais.getId());
				user.setAttribute("nome", credenciais.getNome());
				user.setAttribute("papel", credenciais.getPapel());
				user.setAttribute("login", credenciais.getLogin());
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	@Override
	public void unauthenticate() throws Exception {
		credenciais.clear();
	}

	
	private String getClientIP() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	   //is client behind something?
	   String ipAddress = request.getHeader("x-forwarded-for");  
	   if (ipAddress == null) {  
		   ipAddress = request.getRemoteAddr();  
	   }
	   return ipAddress;
	}
}
