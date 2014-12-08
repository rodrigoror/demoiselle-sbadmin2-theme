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

import org.hibernate.validator.constraints.Length;

/**
 * @author rodrigo@celebrandoavida.com
 */
@Entity
@Table(name="COMPANYEND"/*, schema="SCHEMA"*/)
public class CompanyEnd implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="comp_id"
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name="cend_id")
	private Long cend_id;
	
	@Column(name="cend_cep",nullable=false)
	@Length(max=9)
	@NotNull
	private String cend_cep;
	
	@Column(name="cend_end")
	private String cend_end;
	
	@Column(name="cend_num")
	private String cend_num;
	
	@Column(name="cend_comp")
	private String cend_comp;
	
	@Column(name="cend_bairro")
	private String cend_bairro;
	
	@Column(name="cend_cidade")
	private String cend_cidade;
	
	@Column(name="cend_estado")
	private String cend_estado;
	
	@Column(name="cend_ativo")
	private Boolean cend_ativo;
	
	@Column(name="cend_excluido")
	private Boolean cend_excluido;

	@Column(name="cend_ipUpdate", nullable=false)
	@NotNull
	private String cend_ipUpdate;
	
	@Column(name="cend_loginUpdate", nullable=false)
	@NotNull
	private String cend_loginUpdate;
	
	@Column(name="cend_dtUpdate", nullable=false)
	@NotNull
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date cend_dtUpdate;
	
	@ManyToOne
    @JoinColumn(name="comp_id", nullable=false)	
	private Company cend_company;

	public CompanyEnd() {
		super();
	}

	/**
	 * @param cend_cep
	 * @param cend_end
	 * @param cend_num
	 * @param cend_comp
	 * @param cend_bairro
	 * @param cend_cidade
	 * @param cend_estado
	 * @param cend_ativo
	 * @param cend_excluido
	 * @param cend_ipUpdate
	 * @param cend_loginUpdate
	 * @param cend_dtUpdate
	 * @param cend_company
	 */
	public CompanyEnd(String cend_cep, String cend_end, String cend_num,
			String cend_comp, String cend_bairro, String cend_cidade,
			String cend_estado, Boolean cend_ativo, Boolean cend_excluido,
			String cend_ipUpdate, String cend_loginUpdate, Date cend_dtUpdate,
			Company cend_company) {
		super();
		this.cend_cep = cend_cep;
		this.cend_end = cend_end;
		this.cend_num = cend_num;
		this.cend_comp = cend_comp;
		this.cend_bairro = cend_bairro;
		this.cend_cidade = cend_cidade;
		this.cend_estado = cend_estado;
		this.cend_ativo = cend_ativo;
		this.cend_excluido = cend_excluido;
		this.cend_ipUpdate = cend_ipUpdate;
		this.cend_loginUpdate = cend_loginUpdate;
		this.cend_dtUpdate = cend_dtUpdate;
		this.cend_company = cend_company;
	}

	/**
	 * @return the cend_id
	 */
	public Long getCend_id() {
		return cend_id;
	}

	/**
	 * @param cend_id the cend_id to set
	 */
	public void setCend_id(Long cend_id) {
		this.cend_id = cend_id;
	}

	/**
	 * @return the cend_cep
	 */
	public String getCend_cep() {
		return cend_cep;
	}

	/**
	 * @param cend_cep the cend_cep to set
	 */
	public void setCend_cep(String cend_cep) {
		this.cend_cep = cend_cep;
	}

	/**
	 * @return the cend_end
	 */
	public String getCend_end() {
		return cend_end;
	}

	/**
	 * @param cend_end the cend_end to set
	 */
	public void setCend_end(String cend_end) {
		this.cend_end = cend_end;
	}

	/**
	 * @return the cend_num
	 */
	public String getCend_num() {
		return cend_num;
	}

	/**
	 * @param cend_num the cend_num to set
	 */
	public void setCend_num(String cend_num) {
		this.cend_num = cend_num;
	}

	/**
	 * @return the cend_comp
	 */
	public String getCend_comp() {
		return cend_comp;
	}

	/**
	 * @param cend_comp the cend_comp to set
	 */
	public void setCend_comp(String cend_comp) {
		this.cend_comp = cend_comp;
	}

	/**
	 * @return the cend_bairro
	 */
	public String getCend_bairro() {
		return cend_bairro;
	}

	/**
	 * @param cend_bairro the cend_bairro to set
	 */
	public void setCend_bairro(String cend_bairro) {
		this.cend_bairro = cend_bairro;
	}

	/**
	 * @return the cend_cidade
	 */
	public String getCend_cidade() {
		return cend_cidade;
	}

	/**
	 * @param cend_cidade the cend_cidade to set
	 */
	public void setCend_cidade(String cend_cidade) {
		this.cend_cidade = cend_cidade;
	}

	/**
	 * @return the cend_estado
	 */
	public String getCend_estado() {
		return cend_estado;
	}

	/**
	 * @param cend_estado the cend_estado to set
	 */
	public void setCend_estado(String cend_estado) {
		this.cend_estado = cend_estado;
	}

	/**
	 * @return the cend_ativo
	 */
	public Boolean getCend_ativo() {
		return cend_ativo;
	}

	/**
	 * @param cend_ativo the cend_ativo to set
	 */
	public void setCend_ativo(Boolean cend_ativo) {
		this.cend_ativo = cend_ativo;
	}

	/**
	 * @return the cend_excluido
	 */
	public Boolean getCend_excluido() {
		return cend_excluido;
	}

	/**
	 * @param cend_excluido the cend_excluido to set
	 */
	public void setCend_excluido(Boolean cend_excluido) {
		this.cend_excluido = cend_excluido;
	}

	/**
	 * @return the cend_ipUpdate
	 */
	public String getCend_ipUpdate() {
		return cend_ipUpdate;
	}

	/**
	 * @param cend_ipUpdate the cend_ipUpdate to set
	 */
	public void setCend_ipUpdate(String cend_ipUpdate) {
		this.cend_ipUpdate = cend_ipUpdate;
	}

	/**
	 * @return the cend_loginUpdate
	 */
	public String getCend_loginUpdate() {
		return cend_loginUpdate;
	}

	/**
	 * @param cend_loginUpdate the cend_loginUpdate to set
	 */
	public void setCend_loginUpdate(String cend_loginUpdate) {
		this.cend_loginUpdate = cend_loginUpdate;
	}

	/**
	 * @return the cend_dtUpdate
	 */
	public Date getCend_dtUpdate() {
		return cend_dtUpdate;
	}

	/**
	 * @param cend_dtUpdate the cend_dtUpdate to set
	 */
	public void setCend_dtUpdate(Date cend_dtUpdate) {
		this.cend_dtUpdate = cend_dtUpdate;
	}

	/**
	 * @return the cend_company
	 */
	public Company getCend_company() {
		return cend_company;
	}

	/**
	 * @param cend_company the cend_company to set
	 */
	public void setCend_company(Company cend_company) {
		this.cend_company = cend_company;
	}
	
}
