/**
 * 
 */
package org.rlabs.teste02.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author rodrigo.ramos
 *
 */
@Entity
@Table(name="USERS"/*, schema="SCHEMA"*/)
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
	@Length(max=50)
	private String user_login;
	
	/**
	 * Para uma futura integracao
	 */
	@Column(name="user_cpf", length=11, nullable=false)
	@NotBlank
	@Length(max=11)
	private String user_cpf;
	
	@Column(name="user_senha", nullable=false, length=100)
	@NotNull
	@Length(max=100)
	private String user_senha;
	
	@Column(name="user_susep", length=11, unique=true)
	@NotNull
	@Length(max=11)
	private String user_susep;

	@Column(name="user_nome", nullable=false, length=100)
	@NotNull
	@Length(max=100)
	private String user_nome;
	

	@Column(name="user_telefone", length=10)
	@Length(max=10)
	private String user_telefone;
	
	@Column(name="user_ativo")
	private Boolean user_ativo;
	
	@Column(name="user_excluido")
	private Boolean user_excluido;

	@Column(name="user_ipUpdate", nullable=false)
	private String user_ipUpdate;
	
	@Column(name="user_loginUpdate", nullable=false)
	private String user_loginUpdate;
	
	@Column(name="user_dtUpdate", nullable=false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date user_dtUpdate;
	
	@ManyToOne
	@JoinColumn(name="perf_id", nullable=false)
	private Perfil user_perfil;
	
	@ManyToOne
    @JoinColumn(name="comp_id", nullable=false)	
	private Company user_company;
	
	public Users() {
		super();
	}

	/**
	 * @param user_login
	 * @param user_cpf
	 * @param user_senha
	 * @param user_susep
	 * @param user_nome
	 * @param user_telefone
	 * @param user_ativo
	 * @param user_excluido
	 * @param user_ipUpdate
	 * @param user_loginUpdate
	 * @param user_dtUpdate
	 * @param user_perfil
	 * @param user_company
	 */
	public Users(String user_login, String user_cpf, String user_senha,
			String user_susep, String user_nome, String user_telefone,
			Boolean user_ativo, Boolean user_excluido, String user_ipUpdate,
			String user_loginUpdate, Date user_dtUpdate, Perfil user_perfil,
			Company user_company) {
		super();
		this.user_login = user_login;
		this.user_cpf = user_cpf;
		this.user_senha = user_senha;
		this.user_susep = user_susep;
		this.user_nome = user_nome;
		this.user_telefone = user_telefone;
		this.user_ativo = user_ativo;
		this.user_excluido = user_excluido;
		this.user_ipUpdate = user_ipUpdate;
		this.user_loginUpdate = user_loginUpdate;
		this.user_dtUpdate = user_dtUpdate;
		this.user_perfil = user_perfil;
		this.user_company = user_company;
	}

	/**
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the user_login
	 */
	public String getUser_login() {
		return user_login;
	}

	/**
	 * @param user_login the user_login to set
	 */
	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}

	/**
	 * @return the user_cpf
	 */
	public String getUser_cpf() {
		return user_cpf;
	}

	/**
	 * @param user_cpf the user_cpf to set
	 */
	public void setUser_cpf(String user_cpf) {
		this.user_cpf = user_cpf;
	}

	/**
	 * @return the user_senha
	 */
	public String getUser_senha() {
		return user_senha;
	}

	/**
	 * @param user_senha the user_senha to set
	 */
	public void setUser_senha(String user_senha) {
		this.user_senha = user_senha;
	}

	/**
	 * @return the user_susep
	 */
	public String getUser_susep() {
		return user_susep;
	}

	/**
	 * @param user_susep the user_susep to set
	 */
	public void setUser_susep(String user_susep) {
		this.user_susep = user_susep;
	}

	/**
	 * @return the user_nome
	 */
	public String getUser_nome() {
		return user_nome;
	}

	/**
	 * @param user_nome the user_nome to set
	 */
	public void setUser_nome(String user_nome) {
		this.user_nome = user_nome;
	}

	/**
	 * @return the user_telefone
	 */
	public String getUser_telefone() {
		return user_telefone;
	}

	/**
	 * @param user_telefone the user_telefone to set
	 */
	public void setUser_telefone(String user_telefone) {
		this.user_telefone = user_telefone;
	}

	/**
	 * @return the user_ativo
	 */
	public Boolean getUser_ativo() {
		return user_ativo;
	}

	/**
	 * @param user_ativo the user_ativo to set
	 */
	public void setUser_ativo(Boolean user_ativo) {
		this.user_ativo = user_ativo;
	}

	/**
	 * @return the user_excluido
	 */
	public Boolean getUser_excluido() {
		return user_excluido;
	}

	/**
	 * @param user_excluido the user_excluido to set
	 */
	public void setUser_excluido(Boolean user_excluido) {
		this.user_excluido = user_excluido;
	}

	/**
	 * @return the user_ipUpdate
	 */
	public String getUser_ipUpdate() {
		return user_ipUpdate;
	}

	/**
	 * @param user_ipUpdate the user_ipUpdate to set
	 */
	public void setUser_ipUpdate(String user_ipUpdate) {
		this.user_ipUpdate = user_ipUpdate;
	}

	/**
	 * @return the user_loginUpdate
	 */
	public String getUser_loginUpdate() {
		return user_loginUpdate;
	}

	/**
	 * @param user_loginUpdate the user_loginUpdate to set
	 */
	public void setUser_loginUpdate(String user_loginUpdate) {
		this.user_loginUpdate = user_loginUpdate;
	}

	/**
	 * @return the user_dtUpdate
	 */
	public Date getUser_dtUpdate() {
		return user_dtUpdate;
	}

	/**
	 * @param user_dtUpdate the user_dtUpdate to set
	 */
	public void setUser_dtUpdate(Date user_dtUpdate) {
		this.user_dtUpdate = user_dtUpdate;
	}

	/**
	 * @return the user_perfil
	 */
	public Perfil getUser_perfil() {
		return user_perfil;
	}

	/**
	 * @param user_perfil the user_perfil to set
	 */
	public void setUser_perfil(Perfil user_perfil) {
		this.user_perfil = user_perfil;
	}

	/**
	 * @return the user_company
	 */
	public Company getUser_company() {
		return user_company;
	}

	/**
	 * @param user_company the user_company to set
	 */
	public void setUser_company(Company user_company) {
		this.user_company = user_company;
	}
	
	//TODO: INSERIR O PERFIL
	
}
