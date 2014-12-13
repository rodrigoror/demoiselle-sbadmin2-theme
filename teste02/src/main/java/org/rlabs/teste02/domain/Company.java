/**
 * 
 */
package org.rlabs.teste02.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author rodrigo.ramos
 *
 */
@Entity
@Table(name="COMPANY"/*, schema="SCHEMA"*/)
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="comp_id"
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name="comp_id")
	private Long comp_id;
	
	@Column(name="comp_cnpj", nullable=false)
	private String comp_cnpj;
	
	@Column(name="comp_razaoSocial", nullable=false)
	private String comp_razaoSocial;
	
	@Column(name="comp_nomeFantasia", nullable=false)
	private String comp_nomeFantasia;
	
	@Column(name="comp_pais", nullable=false)
	private String comp_pais;
	
	@Column(name="comp_fone", nullable=false)
	private String comp_fone;
	
	@Column(name="comp_responsavel", nullable=false)
	private String comp_responsavel;
	
	@Column(name="comp_ativo")
	private Boolean comp_ativo;
	
	@Column(name="comp_excluido")
	private Boolean comp_excluido;

	@Column(name="comp_ipUpdate", nullable=false)
	private String comp_ipUpdate;
	
	@Column(name="comp_loginUpdate", nullable=false)
	private String comp_loginUpdate;
	
	@Column(name="comp_dtUpdate", nullable=false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date comp_dtUpdate;
	
	@OneToMany(mappedBy="cend_company")
    private Set<CompanyEnd> companyEnds;
	
	@OneToMany(mappedBy="user_company")
    private Set<Users> companyUsers;

	public Company() {
		super();
	}

	/**
	 * @param comp_cnpj
	 * @param comp_razaoSocial
	 * @param comp_nomeFantasia
	 * @param comp_pais
	 * @param comp_fone
	 * @param comp_responsavel
	 * @param comp_ativo
	 * @param comp_excluido
	 * @param comp_ipUpdate
	 * @param comp_loginUpdate
	 * @param comp_dtUpdate
	 * @param companyEnds
	 */
	public Company(String comp_cnpj, String comp_razaoSocial,
			String comp_nomeFantasia, String comp_pais, String comp_fone,
			String comp_responsavel, Boolean comp_ativo, Boolean comp_excluido,
			String comp_ipUpdate, String comp_loginUpdate, Date comp_dtUpdate
			) {
		super();
		this.comp_cnpj = comp_cnpj;
		this.comp_razaoSocial = comp_razaoSocial;
		this.comp_nomeFantasia = comp_nomeFantasia;
		this.comp_pais = comp_pais;
		this.comp_fone = comp_fone;
		this.comp_responsavel = comp_responsavel;
		this.comp_ativo = comp_ativo;
		this.comp_excluido = comp_excluido;
		this.comp_ipUpdate = comp_ipUpdate;
		this.comp_loginUpdate = comp_loginUpdate;
		this.comp_dtUpdate = comp_dtUpdate;
		
	}

	/**
	 * @return the companyUsers
	 */
	public Set<Users> getCompanyUsers() {
		return companyUsers;
	}

	/**
	 * @param companyUsers the companyUsers to set
	 */
	public void setCompanyUsers(Set<Users> companyUsers) {
		this.companyUsers = companyUsers;
	}

	/**
	 * @return the comp_id
	 */
	public Long getComp_id() {
		return comp_id;
	}

	/**
	 * @param comp_id the comp_id to set
	 */
	public void setComp_id(Long comp_id) {
		this.comp_id = comp_id;
	}

	/**
	 * @return the comp_cnpj
	 */
	public String getComp_cnpj() {
		return comp_cnpj;
	}

	/**
	 * @param comp_cnpj the comp_cnpj to set
	 */
	public void setComp_cnpj(String comp_cnpj) {
		this.comp_cnpj = comp_cnpj;
	}

	/**
	 * @return the comp_razaoSocial
	 */
	public String getComp_razaoSocial() {
		return comp_razaoSocial;
	}

	/**
	 * @param comp_razaoSocial the comp_razaoSocial to set
	 */
	public void setComp_razaoSocial(String comp_razaoSocial) {
		this.comp_razaoSocial = comp_razaoSocial;
	}

	/**
	 * @return the comp_nomeFantasia
	 */
	public String getComp_nomeFantasia() {
		return comp_nomeFantasia;
	}

	/**
	 * @param comp_nomeFantasia the comp_nomeFantasia to set
	 */
	public void setComp_nomeFantasia(String comp_nomeFantasia) {
		this.comp_nomeFantasia = comp_nomeFantasia;
	}

	/**
	 * @return the comp_pais
	 */
	public String getComp_pais() {
		return comp_pais;
	}

	/**
	 * @param comp_pais the comp_pais to set
	 */
	public void setComp_pais(String comp_pais) {
		this.comp_pais = comp_pais;
	}

	/**
	 * @return the comp_fone
	 */
	public String getComp_fone() {
		return comp_fone;
	}

	/**
	 * @param comp_fone the comp_fone to set
	 */
	public void setComp_fone(String comp_fone) {
		this.comp_fone = comp_fone;
	}

	/**
	 * @return the comp_responsavel
	 */
	public String getComp_responsavel() {
		return comp_responsavel;
	}

	/**
	 * @param comp_responsavel the comp_responsavel to set
	 */
	public void setComp_responsavel(String comp_responsavel) {
		this.comp_responsavel = comp_responsavel;
	}

	/**
	 * @return the comp_ativo
	 */
	public Boolean getComp_ativo() {
		return comp_ativo;
	}

	/**
	 * @param comp_ativo the comp_ativo to set
	 */
	public void setComp_ativo(Boolean comp_ativo) {
		this.comp_ativo = comp_ativo;
	}

	/**
	 * @return the comp_excluido
	 */
	public Boolean getComp_excluido() {
		return comp_excluido;
	}

	/**
	 * @param comp_excluido the comp_excluido to set
	 */
	public void setComp_excluido(Boolean comp_excluido) {
		this.comp_excluido = comp_excluido;
	}

	/**
	 * @return the comp_ipUpdate
	 */
	public String getComp_ipUpdate() {
		return comp_ipUpdate;
	}

	/**
	 * @param comp_ipUpdate the comp_ipUpdate to set
	 */
	public void setComp_ipUpdate(String comp_ipUpdate) {
		this.comp_ipUpdate = comp_ipUpdate;
	}

	/**
	 * @return the comp_loginUpdate
	 */
	public String getComp_loginUpdate() {
		return comp_loginUpdate;
	}

	/**
	 * @param comp_loginUpdate the comp_loginUpdate to set
	 */
	public void setComp_loginUpdate(String comp_loginUpdate) {
		this.comp_loginUpdate = comp_loginUpdate;
	}

	/**
	 * @return the comp_dtUpdate
	 */
	public Date getComp_dtUpdate() {
		return comp_dtUpdate;
	}

	/**
	 * @param comp_dtUpdate the comp_dtUpdate to set
	 */
	public void setComp_dtUpdate(Date comp_dtUpdate) {
		this.comp_dtUpdate = comp_dtUpdate;
	}

	/**
	 * @return the companyEnds
	 */
	public Set<CompanyEnd> getCompanyEnds() {
		return companyEnds;
	}

	/**
	 * @param companyEnds the companyEnds to set
	 */
	public void setCompanyEnds(Set<CompanyEnd> companyEnds) {
		this.companyEnds = companyEnds;
	}

	
	
	
}
