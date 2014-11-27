package org.rlabs.teste02.view;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.sp.sjc.fadenp2.business.UsuarioBC;
import br.gov.sp.sjc.fadenp2.exception.BusinessException;

@ViewController
@PreviousView("/usuario_list.jsf")
@NextView("/index.jsf")
@RequiredRole({"ADMINISTRADOR", "ADMINISTRATIVO"})
public class UsuarioRecuperarSenhaMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;
	
	@Inject
	private Logger logger;

	@Inject
	private UsuarioBC usuarioBC;
	
	@Inject
	private ResourceBundle resourceBundle;

	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNomePessoa(){
		return usuarioBC.load(getId()).getUsua_nome().toString();
	}
	
	public String getCpfPessoa(){
		return usuarioBC.load(getId()).getCpfFormatado().toString();
	}
	
	/** 
	 * Acadêmico do 3º ano de Sistemas de Informação - FIMES - Mineiros - GO 
	 * Alterado para gerar senhas com letras e numeros em todas as vezes.
	 * @author Walfrides Marçal 
	 * @see http://www.guj.com.br/java/67904-gerador-de-senha-alfanumerico
	 */ 
	private String geraSenha(){
		String[] carct = {
				"a","b","c","d","e","f","g","h","i","j","k","m","n","p","q","r","s","t","u","v","w","x","y","z",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"
				}; 
		String[] carct2 = {
				"2","3","4","5","6","7","8","9"
			};
		
		String senha=""; 
		for (int x=0; x<5; x++){ 
			int j = (int) (Math.random()*carct.length); 
			senha += carct[j]; 
		} 
		for (int a=0; a<3; a++){ 
			int b = (int) (Math.random()*carct2.length); 
			senha += carct2[b]; 
		} 
		return senha; 
	} 
	
	public Long getId() {
			Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			try {
				logger.info("-------------ID:"+Long.parseLong(params.get("id")));
				return Long.parseLong(params.get("id"));
			} catch (BusinessException e) {
				
				throw new BusinessException(resourceBundle.getString("usuario.mensagem.erro.id",e.getMessage()));
			}
	}
	
	public void getGerarSenha(){
		this.setSenha(geraSenha());
		logger.info("-------------Senha:"+senha);
		getAlterarSenha(getId());
		messageContext.add(resourceBundle.getString("usuario.mensagem.altera.senha",getNomePessoa(),this.getSenha()), SeverityType.WARN, "");
	}
	
	private void getAlterarSenha(Long id){
		usuarioBC.setForceNovaSenha(getLogin(id), senha);
	}

	private String getLogin(Long id) {
		return usuarioBC.load(id).getUsua_login();
	}

	@ExceptionHandler
	public void tratador(BusinessException ex) {
		messageContext.add(ex.getMessage(), SeverityType.ERROR, "");
	}


}
