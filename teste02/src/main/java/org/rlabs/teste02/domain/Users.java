/**
 * 
 */
package org.rlabs.teste02.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author rodrigo.ramos
 *
 */
public class Users implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="usua_id"
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name="user_id", nullable=false)
	private Long user_id;
	
	/**
	 * O Login deve ser o email.
	 */
	@Column(name="user_login", length=50, nullable=false, unique=true)
	@NotBlank
	@Email
	private String user_login;
	
	/**
	 * Para uma futura integracao
	 */
	@Column(name="user_cpf", length=11, nullable=false)
	//@Cpf
	@NotBlank
	private String user_cpf;
	
	/**
	 */
	@Column(name="user_senha", nullable=false, length=100)
	@NotBlank
	private String user_senha;
	
	/**
	 * Ativo
	 */
	@Column(name="user_ativo")
	private Boolean user_ativo;
	
	/**
	 */
	@Column(name="user_perfil", nullable=false)
	@NotBlank
	private String user_perfil;
	
	/**
	 * 
	 */
	@Column(name="user_insertUpdate", length=50, nullable=false)
	private String user_insertUpdate;
	
	/**
	 * 
	 */
	@Column(name="user_dtInsertUpdate")
	@Temporal(value=TemporalType.DATE)
	private Date user_dtInsertUpdate;
	
	/**
	 * 
	 */
	@Column(name="user_susep", length=11)
	private String user_susep;
	
	/**
	 * 
	 */
	@Column(name="user_nome", nullable=false, length=50)
	@NotBlank
	private String user_nome;
	
	/**
	 * 
	 */
	@Column(name="user_telefone", length=10)
	private String user_telefone;
	
	/**
	 * 
	 */
	@Column(name="user_celphone", length=11)
	private String user_celphone;
	
	/**
	 * 
	 */
	@Column(name="user_endereco", length=250)
	private String user_endereco;
	
	/**
	 * 
	 */
	@Column(name="user_cep", length=12)
	private String user_cep;
	
	/**
	 * 
	 */
	@Column(name="user_emailSecundario", length=120)
	private String user_emailSecundario;
	
}
