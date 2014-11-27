package org.rlabs.teste02.view;

import javax.inject.Inject;

import org.hibernate.validator.constraints.NotBlank;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.gov.sp.sjc.fadenp2.business.UsuarioBC;
import br.gov.sp.sjc.fadenp2.exception.BusinessException;

@ViewController
@PreviousView("/index.jsf")
@RequiredRole({"ADMINISTRADOR", "COORDENADOR", "GERENTE", "ADMINISTRATIVO", "SUPERVISOR"})
public class UsuarioAlterarSenhaMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private UsuarioBC usuarioBC;
	
	@NotBlank
	private String senhaAtual;
	
	@NotBlank
	private String novaSenha;
	
	@NotBlank
	private String novaSenhaRepeticao;

	public String getSenhaAtual() {
		return senhaAtual;
	}
	
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}
	
	public String getNovaSenha() {
		return novaSenha;
	}
	
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
	public String getNovaSenhaRepeticao() {
		return novaSenhaRepeticao;
	}
	
	public void setNovaSenhaRepeticao(String novaSenhaRepeticao) {
		this.novaSenhaRepeticao = novaSenhaRepeticao;
	}
	
	public void alterarSenha() {
		usuarioBC.setNovaSenha((String)securityContext.getUser().getAttribute("login"), senhaAtual, novaSenha, novaSenhaRepeticao);
		messageContext.add("Senha alterada com sucesso!", SeverityType.INFO, "");
	}
	
	@ExceptionHandler
	public void tratador(BusinessException ex) {
		messageContext.add(ex.getMessage(), SeverityType.ERROR, "");
	}

}
