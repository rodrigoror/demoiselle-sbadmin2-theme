package org.rlabs.teste02.domain;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import br.gov.frameworkdemoiselle.component.validation.annotation.Cpf;
import br.gov.sp.sjc.fadenp2.util.CpfUtil;

/**
 * Esta classe deve ser a classe principal para login do usuario
 * @see  https://github.com/clovisjunior/laboratory/blob/master/escola-2.3.1/src/main/java/br/gov/demoiselle/escola/bean/Usuario.java
 * @author  bruno.cristiano
 */

@Entity
@Table(name="usuario", schema="FADENP")
@SequenceGenerator(name="sq_usuario", sequenceName="FADENP.SQ_USUARIO")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="usua_id"
	 */
	@Id 
	@GeneratedValue(generator="sq_usuario")
	@Column(name="usua_id", nullable=false)
	
	private Long usua_id;
	
	/**
	 * @uml.property  name="usua_nome"
	 */
	@Column(name="usua_nome", nullable=false, length=50)
	@NotBlank
	private String usua_nome;
	
	/** O Login deve ser o email.*/
	/**
	 * O Login deve ser o email.
	 * @uml.property  name="usua_login"
	 */
	@Column(name="usua_login", length=50, nullable=false, unique=true)
	@NotBlank
	@Email
	private String usua_login;
	
	/**
	 * Para uma futura integracao com o SGRH
	 * @uml.property  name="usua_cpf"
	 */
	@Column(name="usua_cpf", length=11, nullable=false)
	@Cpf
	@NotBlank
	private String usua_cpf;	
	
	/**
	 * @uml.property  name="usua_senha"
	 */
	@Column(name="usua_senha", nullable=false, length=100)
	@NotBlank
	private String usua_senha;
	
	/**
	 * 
	 * @uml.property  name="usua_telefones"
	 */
	@Column(name="usua_telefones", length=50)
	private String usua_telefones;
	
	/**
	 * 
	 * @uml.property  name="usua_usrcadastro"
	 */
	@Column(name="usua_usrcadastro", length=50, nullable=false)
	private String usua_usrcadastro;
	
	/**
	 * @uml.property  name="usua_dtcadastro"
	 */
	@Column(name="usua_dtcadastro")
	@Temporal(value=TemporalType.DATE)
	private Date usua_dtcadastro;
	
	/**
	 * @uml.property  name="usua_perfil"
	 * @uml.associationEnd  
	 */
	@ManyToOne
	@JoinColumn(name="perf_id", nullable=false)
	private Perfil usua_perfil;
	
	/**
	 * @uml.property  name="usua_matricula"
	 */
	@Column(name="usua_ativo")
	private boolean usua_ativo;	
	
	@OneToMany(mappedBy="equi_coordenador_equipe", fetch=FetchType.LAZY)
    private Set<Equipe> equipes;		
	
	@OneToMany(mappedBy="equi_coordenador_gerencial", fetch=FetchType.LAZY)
    private Set<Equipe> equipesg;	
	
	
	/**Metodo compara o Objeto Login passado com o Login que ja contem
	 * no sistema.
	* @return O Metodo retorna TRUE ou FALSE
	*/
	
	@Override
	public boolean equals(Object obj) {
		return ((Usuario)obj).usua_login.equals(this.usua_login);
	};
	
	
	/**
	 * Retorna o valor Long da variavel usua_Id 
	 * @return
	 * @uml.property  name="usua_id"
	 */
	public Long getUsua_id() {
		return usua_id;
	}
	

	/**
	 * Insere o Valor long na variavel usua_id
	 * @param usua_id
	 * @uml.property  name="usua_id"
	 */
	public void setUsua_id(Long usua_id) {
		this.usua_id = usua_id;
	}
	

	/**Retorna o valor String da variavel usua_cpf 
	 * @return
	 * @uml.property  name="usua_matricula"
	 */
	public String getUsua_cpf() {
		return usua_cpf;
	}
	

	/**
	 * Insere o Valor String na variavel usua_cpf
	 * @param usua_matricula
	 * @uml.property  name="usua_matricula"
	 */
	public void setUsua_cpf(String usua_cpf) {
		this.usua_cpf = usua_cpf.replaceAll("\\D+",""); // pega somente numeros
	}
	
	
	/**
	 * Retorna o Valor String da variavel usua_senha
	 * @return
	 * @uml.property  name="usua_senha"
	 */
	public String getUsua_senha() {
		return usua_senha;
	}
	

	/**
	 * Insere o Valor String na variavel usua_senha 
	 * @param usua_senha
	 * @uml.property  name="usua_senha"
	 */
	public void setUsua_senha(String usua_senha) {
		this.usua_senha = usua_senha;
	}
	

	/**
	 * Retorna o Valor String da variavel usua_telefones
	 * @return
	 * @uml.property  name="usua_telefones"
	 */
	public String getUsua_telefones() {
		return usua_telefones;
	}
	
	/**
	 * Insere o Valor String na variavel usua_usrcadastro
	 * @param usua_telefones
	 * @uml.property  name="usua_telefones"
	 */
	public void setUsua_telefones(String usua_telefones) {
		this.usua_telefones = usua_telefones;
	}	
	
	/**
	 * Retorna o Valor String da variavel usua_usrcadastro
	 * @return
	 * @uml.property  name="usua_usrcadastro"
	 */
	public String getUsua_usrcadastro() {
		return usua_usrcadastro;
	}
	

	/**
	 * Insere o Valor String na variavel usua_usrcadastro
	 * @param usua_usrcadastro
	 * @uml.property  name="usua_usrcadastro"
	 */
	public void setUsua_usrcadastro(String usua_usrcadastro) {
		this.usua_usrcadastro = usua_usrcadastro;
	}
	

	/**
	 * Retorna o Valor Date da variavel usua_dtcadastro
	 * @return
	 * @uml.property  name="usua_dtcadastro"
	 */
	public Date getUsua_dtcadastro() {
		return usua_dtcadastro;
	}
	

	/**
	 * Insere o Valor Date na variavel usua_dtcadastro
	 * @param usua_dtcadastro
	 * @uml.property  name="usua_dtcadastro"
	 */
	public void setUsua_dtcadastro(Date usua_dtcadastro) {
		this.usua_dtcadastro = usua_dtcadastro;
	}
	

	/**
	 * Insere o Valor String da variavel usua_nome
	 * @param usua_nome
	 * @uml.property  name="usua_nome"
	 */
	public void setUsua_nome(String usua_nome) {
		this.usua_nome = usua_nome;
	}
	

	/**
	 * Retorna o Valor String na variavel usua_nome
	 * @return
	 * @uml.property  name="usua_nome"
	 */
	public String getUsua_nome() {
		return usua_nome;
	}
	

	/**
	 * Insere o Valor String da variavel usua_login
	 * @param usua_login
	 * @uml.property  name="usua_login"
	 */
	public void setUsua_login(String usua_login) {
		if (usua_login != null) {
			this.usua_login = usua_login.toLowerCase();
		} else {
			this.usua_login = usua_login;
		}
	}
	

	/**
	 * Retorna o Valor String na variavel usua_login
	 * @return
	 * @uml.property  name="usua_login"
	 */
	public String getUsua_login() {
		return usua_login;
	}
	

	/**
	 * * Insere o Valor Perfil na variavel usua_perfil
	 * @param usua_perfil
	 * @uml.property  name="usua_perfil"
	 */
	public void setUsua_perfil(Perfil usua_perfil) {
		this.usua_perfil = usua_perfil;
	}
	

	/**
	 * * Retorna o Valor Perfil da variavel usua_perfil
	 * @return
	 * @uml.property  name="usua_perfil"
	 */
	public Perfil getUsua_perfil() {
		return usua_perfil;
	}
	

	/** Insere o Valor boolean na variavel usua_perfil*/
	public void setUsua_ativo(boolean usua_ativo) {
		this.usua_ativo = usua_ativo;
	}
	
	
	/** Retorna o Valor Perfil da variavel usua_perfil*/
	public boolean isUsua_ativo() {
		return usua_ativo;
	}
	

	/**Metodo verifica se e Ativo retorna sim para um resultado positivo e nao para um resutado negativo*/
	@Transient
	public String getUserAtivo(){
		if(this.usua_ativo ){
			return "Sim";
			
		}else{
			return "Não";
		}
	}
	
	
	public Usuario() {
		super();
	}
	

	public Usuario(String usua_nome, String usua_login, String usua_cpf,
			String usua_senha, String usua_usrcadastro, Date usua_dtcadastro,
			Perfil usua_perfil, boolean usua_ativo) {
		super();
		this.usua_nome = usua_nome;   
	    this.usua_login = usua_login;
	    this.usua_cpf = usua_cpf;
		this.usua_senha = usua_senha;
		this.usua_usrcadastro = usua_usrcadastro;
		this.usua_dtcadastro = usua_dtcadastro;
		this.usua_perfil = usua_perfil;
		this.usua_ativo = usua_ativo;
	}
	

	/** Metodo que acessa "equi_coordenador_gerencial" */
	public void setEquipesg(Set<Equipe> equipesg) {
		this.equipesg = equipesg;
	}
	
	
	/** Metodo que acessa "equi_coordenador_gerencial" */
	public Set<Equipe> getEquipesg() {
		return equipesg;
	}
	
	
	/** Metodo que acessa"equi_coordenador_equipe"*/
	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	
	/** Metodo que acessa"equi_coordenador_equipe"*/
	public Set<Equipe> getEquipes() {
		return equipes;
	}
	
	
	/** Metodo que formata o Cpf para os padroes necessarios*/
	@Transient
	public String getCpfFormatado() {
		String aux = this.usua_cpf;
		try {
			return CpfUtil.formataCpf(aux);
		} catch (RuntimeException ex) {
			return aux;
		}
	}

	
	/**
	 * Metodo Padrao Auditoria 
	 */
	@Transient
	public String getDadosAuditoria() {
		return "Usuario [usua_id=" + usua_id + ", usua_nome=" + usua_nome
				+ ", usua_login=" + usua_login + ", usua_cpf=" + usua_cpf
				+ ", usua_senha=" + usua_senha + ", usua_usrcadastro="
				+ usua_usrcadastro + ", usua_dtcadastro=" + usua_dtcadastro
				+ ", usua_perfil=" + usua_perfil.getPerf_id() + ", usua_ativo=" + usua_ativo
				+ ", usua_telefones=" + usua_telefones + "]";
	}

}
