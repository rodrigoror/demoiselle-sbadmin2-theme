package org.rlabs.teste02.view;

import javax.inject.Inject;
import javax.naming.AuthenticationException;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.AuthorizationException;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import org.rlabs.teste02.exception.NaoLogadoException;
import org.rlabs.teste02.security.Credenciais;
import org.rlabs.teste02.util.LoggerUtil;

@ViewController
public class LoginMB extends AbstractPageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoggerUtil logger;
	
	@Inject
	private Credenciais credenciais;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private MessageContext messageContext;
	
	@Inject
	private ResourceBundle bundle;

	public Credenciais getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(Credenciais credenciais) {
		this.credenciais = credenciais;
	}
	
	public void login(){
		try {
			securityContext.login();
		} catch (RuntimeException e) {
			logger.error("{mensagem.credenciais.login.erro} "+e.getMessage());
			messageContext.add(e.getMessage(), SeverityType.ERROR, "");
		}
	}
	
	public void logout(){
		logger.info("logout()");
		
		if (securityContext.getUser().getId() != null) {
			
			logger.info("logout() securityContext.logout()");
			securityContext.logout();
		} else {
			logger.error("{mensagem.credenciais.logout.erro}");
		}
	}
	

	@ExceptionHandler
	public void tratador(AuthenticationException e){
		messageContext.add(bundle.getString("login.invalido"),SeverityType.ERROR,"");
	}
	
	@ExceptionHandler
	public void tratador(AuthorizationException e){
		messageContext.add(bundle.getString("login.invalido"),SeverityType.ERROR,"");
	}
	
	
	@ExceptionHandler
	public void tratador(NaoLogadoException e){
		messageContext.add(bundle.getString("login.invalido"),SeverityType.ERROR,"");
	}
	


	/**
	 * Verifica se o usuário logado possui um dos papéis informados. Usado no menu.xhtml.
	 * @param papeis (string vazia, ou string com os papéis separados por vírgula)
	 * @return
	 */

	public boolean TemPermissao(String descricao){
		logger.info("TemPermissao() "+descricao);
		return securityContext.hasRole(descricao); 
		
	}
	
	
	/*//recupera o ambiente para exibir na tela de login
	public String getAmbiente(){
		return configuracaoBC.findByCodigo(1L).getAmbiente();
	}*/
	
		
	
}
