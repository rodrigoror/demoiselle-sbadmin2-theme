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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Classe que contem o perfil dos usuarios, inicialmente serão apresenta
 * @author rodrigo.ramos
 */
@Entity
@Table(name="PERFIL"/*, schema="SCHEMA"*/)
public class Perfil implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name="perf_id")
	private Long perf_id;
	
	@Column (name="perf_descricao", nullable=false, length=50)
	@NotBlank
	private String perf_descricao;
	
	@Column (name="perf_codigo", nullable=false, length=50, unique=true)
	@NotBlank
	private String perf_codigo;
	
	@Column(name="perf_ativo")
	private Boolean perf_ativo;
	
	@Column(name="perf_excluido")
	private Boolean perf_excluido;

	@Column(name="perf_ipUpdate", nullable=false)
	private String perf_ipUpdate;
	
	@Column(name="perf_loginUpdate", nullable=false)
	private String perf_loginUpdate;
	
	@Column(name="perf_dtUpdate", nullable=false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date perf_dtUpdate;
	
	@OneToMany(mappedBy="user_perfil", fetch=FetchType.LAZY)
    private Set<Users> perfilUsers;

	/**
	 * 
	 */
	public Perfil() {
		super();
	}

	/**
	 * @param perf_descricao
	 * @param perf_codigo
	 * @param perf_ativo
	 * @param perf_excluido
	 * @param perf_ipUpdate
	 * @param perf_loginUpdate
	 * @param perf_dtUpdate
	 */
	public Perfil(String perf_descricao, String perf_codigo,
			Boolean perf_ativo, Boolean perf_excluido, String perf_ipUpdate,
			String perf_loginUpdate, Date perf_dtUpdate) {
		super();
		this.perf_descricao = perf_descricao;
		this.perf_codigo = perf_codigo;
		this.perf_ativo = perf_ativo;
		this.perf_excluido = perf_excluido;
		this.perf_ipUpdate = perf_ipUpdate;
		this.perf_loginUpdate = perf_loginUpdate;
		this.perf_dtUpdate = perf_dtUpdate;
		
	}

	/**
	 * @return the perf_id
	 */
	public Long getPerf_id() {
		return perf_id;
	}

	/**
	 * @param perf_id the perf_id to set
	 */
	public void setPerf_id(Long perf_id) {
		this.perf_id = perf_id;
	}

	/**
	 * @return the perf_descricao
	 */
	public String getPerf_descricao() {
		return perf_descricao;
	}

	/**
	 * @param perf_descricao the perf_descricao to set
	 */
	public void setPerf_descricao(String perf_descricao) {
		this.perf_descricao = perf_descricao;
	}

	/**
	 * @return the perf_codigo
	 */
	public String getPerf_codigo() {
		return perf_codigo;
	}

	/**
	 * @param perf_codigo the perf_codigo to set
	 */
	public void setPerf_codigo(String perf_codigo) {
		this.perf_codigo = perf_codigo;
	}

	/**
	 * @return the perf_ativo
	 */
	public Boolean getPerf_ativo() {
		return perf_ativo;
	}

	/**
	 * @param perf_ativo the perf_ativo to set
	 */
	public void setPerf_ativo(Boolean perf_ativo) {
		this.perf_ativo = perf_ativo;
	}

	/**
	 * @return the perf_excluido
	 */
	public Boolean getPerf_excluido() {
		return perf_excluido;
	}

	/**
	 * @param perf_excluido the perf_excluido to set
	 */
	public void setPerf_excluido(Boolean perf_excluido) {
		this.perf_excluido = perf_excluido;
	}

	/**
	 * @return the perf_ipUpdate
	 */
	public String getPerf_ipUpdate() {
		return perf_ipUpdate;
	}

	/**
	 * @param perf_ipUpdate the perf_ipUpdate to set
	 */
	public void setPerf_ipUpdate(String perf_ipUpdate) {
		this.perf_ipUpdate = perf_ipUpdate;
	}

	/**
	 * @return the perf_loginUpdate
	 */
	public String getPerf_loginUpdate() {
		return perf_loginUpdate;
	}

	/**
	 * @param perf_loginUpdate the perf_loginUpdate to set
	 */
	public void setPerf_loginUpdate(String perf_loginUpdate) {
		this.perf_loginUpdate = perf_loginUpdate;
	}

	/**
	 * @return the perf_dtUpdate
	 */
	public Date getPerf_dtUpdate() {
		return perf_dtUpdate;
	}

	/**
	 * @param perf_dtUpdate the perf_dtUpdate to set
	 */
	public void setPerf_dtUpdate(Date perf_dtUpdate) {
		this.perf_dtUpdate = perf_dtUpdate;
	}

	/**
	 * @return the perfilUsers
	 */
	public Set<Users> getPerfilUsers() {
		return perfilUsers;
	}

	/**
	 * @param perfilUsers the perfilUsers to set
	 */
	public void setPerfilUsers(Set<Users> perfilUsers) {
		this.perfilUsers = perfilUsers;
	}

	/**
	 * Usado para auditoria e log
	 * @see java.lang.Object#toString()
	 */
	@Transient
	public String getLog() {
		return "Perfil [perf_id=" + perf_id + ", perf_descricao="
				+ perf_descricao + ", perf_codigo=" + perf_codigo
				+ ", perf_ativo=" + perf_ativo + ", perf_excluido="
				+ perf_excluido + ", perf_ipUpdate=" + perf_ipUpdate
				+ ", perf_loginUpdate=" + perf_loginUpdate + ", perf_dtUpdate="
				+ perf_dtUpdate + "]";
	}
	
	
	
}
