/**
 * 
 */
package org.rlabs.teste02.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author rodrigo.ramos
 *
 */
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="comp_id"
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name="comp_id", nullable=false)
	private Long comp_id;
	
	@Column(name="comp_cnpj", nullable=false)
	private String comp_cnpj;
	
	@Column(name="comp_razaoSocial", nullable=false)
	private String comp_razaoSocial;
	
	@Column(name="comp_nomeFantasia", nullable=false)
	private String comp_nomeFantasia;
	
	@Column(name="comp_fone", nullable=false)
	private String comp_fone;
	
	@Column(name="comp_responsavel", nullable=false)
	private String comp_responsavel;
	
	@Column(name="comp_IEIM")
	private String comp_IEIM;
	
	@Column(name="comp_susep", nullable=false)
	private String comp_susep;
	
	@Column(name="comp_CEP", nullable=false)
	private String comp_CEP;
	
	@Column(name="comp_pais", nullable=false)
	private String comp_pais;
		
	@Column(name="comp_end", nullable=false)
	private String comp_end;
	
	@Column(name="comp_endNum", nullable=false)
	private String comp_endNum;
	
	@Column(name="comp_endComp", nullable=false)
	private String comp_endComp;
	
	@Column(name="comp_bairro", nullable=false)
	private String comp_bairro;
	
	@Column(name="comp_cidade", nullable=false)
	private String comp_cidade;
	
	@Column(name="comp_ativo")
	private Boolean comp_ativo;
	
	@Column(name="comp_excluido")
	private Boolean comp_excluido;

	public Long getComp_id() {
		return comp_id;
	}

	public void setComp_id(Long comp_id) {
		this.comp_id = comp_id;
	}

	public String getComp_cnpj() {
		return comp_cnpj;
	}

	public void setComp_cnpj(String comp_cnpj) {
		this.comp_cnpj = comp_cnpj;
	}

	public String getComp_razaoSocial() {
		return comp_razaoSocial;
	}

	public void setComp_razaoSocial(String comp_razaoSocial) {
		this.comp_razaoSocial = comp_razaoSocial;
	}

	public String getComp_nomeFantasia() {
		return comp_nomeFantasia;
	}

	public void setComp_nomeFantasia(String comp_nomeFantasia) {
		this.comp_nomeFantasia = comp_nomeFantasia;
	}

	public String getComp_fone() {
		return comp_fone;
	}

	public void setComp_fone(String comp_fone) {
		this.comp_fone = comp_fone;
	}

	public String getComp_responsavel() {
		return comp_responsavel;
	}

	public void setComp_responsavel(String comp_responsavel) {
		this.comp_responsavel = comp_responsavel;
	}

	public String getComp_IEIM() {
		return comp_IEIM;
	}

	public void setComp_IEIM(String comp_IEIM) {
		this.comp_IEIM = comp_IEIM;
	}

	public String getComp_susep() {
		return comp_susep;
	}

	public void setComp_susep(String comp_susep) {
		this.comp_susep = comp_susep;
	}

	public String getComp_CEP() {
		return comp_CEP;
	}

	public void setComp_CEP(String comp_CEP) {
		this.comp_CEP = comp_CEP;
	}

	public String getComp_pais() {
		return comp_pais;
	}

	public void setComp_pais(String comp_pais) {
		this.comp_pais = comp_pais;
	}

	public String getComp_end() {
		return comp_end;
	}

	public void setComp_end(String comp_end) {
		this.comp_end = comp_end;
	}

	public String getComp_endNum() {
		return comp_endNum;
	}

	public void setComp_endNum(String comp_endNum) {
		this.comp_endNum = comp_endNum;
	}

	public String getComp_endComp() {
		return comp_endComp;
	}

	public void setComp_endComp(String comp_endComp) {
		this.comp_endComp = comp_endComp;
	}

	public String getComp_bairro() {
		return comp_bairro;
	}

	public void setComp_bairro(String comp_bairro) {
		this.comp_bairro = comp_bairro;
	}

	public String getComp_cidade() {
		return comp_cidade;
	}

	public void setComp_cidade(String comp_cidade) {
		this.comp_cidade = comp_cidade;
	}

	public Boolean getComp_ativo() {
		return comp_ativo;
	}

	public void setComp_ativo(Boolean comp_ativo) {
		this.comp_ativo = comp_ativo;
	}

	public Boolean getComp_excluido() {
		return comp_excluido;
	}

	public void setComp_excluido(Boolean comp_excluido) {
		this.comp_excluido = comp_excluido;
	}

	public Company() {
		super();
	}

	@Override
	public String toString() {
		return "Company [comp_id=" + comp_id + ", comp_cnpj=" + comp_cnpj
				+ ", comp_razaoSocial=" + comp_razaoSocial
				+ ", comp_nomeFantasia=" + comp_nomeFantasia + ", comp_fone="
				+ comp_fone + ", comp_responsavel=" + comp_responsavel
				+ ", comp_IEIM=" + comp_IEIM + ", comp_susep=" + comp_susep
				+ ", comp_CEP=" + comp_CEP + ", comp_pais=" + comp_pais
				+ ", comp_end=" + comp_end + ", comp_endNum=" + comp_endNum
				+ ", comp_endComp=" + comp_endComp + ", comp_bairro="
				+ comp_bairro + ", comp_cidade=" + comp_cidade
				+ ", comp_ativo=" + comp_ativo + ", comp_excluido="
				+ comp_excluido + "]";
	}

	public Company(String comp_cnpj, String comp_razaoSocial,
			String comp_nomeFantasia, String comp_fone,
			String comp_responsavel, String comp_IEIM, String comp_susep,
			String comp_CEP, String comp_pais, String comp_end,
			String comp_endNum, String comp_endComp, String comp_bairro,
			String comp_cidade, Boolean comp_ativo, Boolean comp_excluido) {
		super();
		this.comp_cnpj = comp_cnpj;
		this.comp_razaoSocial = comp_razaoSocial;
		this.comp_nomeFantasia = comp_nomeFantasia;
		this.comp_fone = comp_fone;
		this.comp_responsavel = comp_responsavel;
		this.comp_IEIM = comp_IEIM;
		this.comp_susep = comp_susep;
		this.comp_CEP = comp_CEP;
		this.comp_pais = comp_pais;
		this.comp_end = comp_end;
		this.comp_endNum = comp_endNum;
		this.comp_endComp = comp_endComp;
		this.comp_bairro = comp_bairro;
		this.comp_cidade = comp_cidade;
		this.comp_ativo = comp_ativo;
		this.comp_excluido = comp_excluido;
	}

	//TODO: Retirar os dados de responsavel desta classe e retirar os dados de endereço

}
