package org.rlabs.teste02.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author  rodrigo.ramos
 */
@SessionScoped
public class Credenciais implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="login"
	 */
	@NotBlank
	private String login;
	
	/**
	 * @uml.property  name="senha"
	 */
	@NotBlank
	private String senha;
	
	private Long id;
	
	private String nome;
	
	private String papel;
	

	public Credenciais() {
		super();
	}
	

	public Credenciais(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	

	public void clear() {
		this.setLogin(null);
		this.setSenha(null);
		this.setId(null);
		this.setNome(null);
		this.setPapel(null);
	}
	

	/**
	 * Metodos Get's and Set's
	 * @return
	 * @uml.property  name="login"
	 */
	public String getLogin() {
		return login;
	}
	
	
	/**
	 * @param login
	 * @uml.property  name="login"
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	/**
	 * @return
	 * @uml.property  name="senha"
	 */
	public String getSenha() {
		return senha;
	}
	
	
	/**
	 * @param senha
	 * @uml.property  name="senha"
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getPapel() {
		return papel;
	}
	

	public void setPapel(String papel) {
		this.papel = papel;
	}
	
}
