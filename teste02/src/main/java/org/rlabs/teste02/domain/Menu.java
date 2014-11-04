/**
 * Classe que identifica o menu
 */
package org.rlabs.teste02.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Classe que identifica o menu
 * @author rodrigo.ramos
 */
@Entity
@Table(name="MENU"/*, schema="LOGRADOURO"*/)
public class Menu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 *  If you are using Glassfish then remove the strategy attribute
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name="menu_id")
	private Long menu_id;
	
	@Column(name="menu_classe")
	@Length(max=25)
	private String menu_classe;
	
	@Column(name="menu_link")
	@Length(max=100)
	@NotNull
	private String menu_link;
	
	@Column(name="menu_permissao")
	@Length(max=10)
	@NotNull
	private String menu_permissao;
	
	@Column(name="menu_nome")
	@Length(max=25)
	@NotNull
	private String menu_nome;
	
	@Column(name="menu_parent")
	@Length(max=10)
	private String menu_parent;
	
	/* @NotNull
	 * @Column(name="menu_parent")
	 * @Column(name="audi_dml", nullable=false, columnDefinition="CHAR")
	 * @Length(max=10)
	 * @Temporal(value = TemporalType.TIMESTAMP)
	 * @Lob
	 * @GeneratedValue(generator="sq_bairro")
	 * @SequenceGenerator(name="sq_bairro", sequenceName="LOGRADOURO.SQ_BAIRRO")
	 * private String parent;
	 */
	
	/**
	 * @return the menu_id
	 */
	public Long getMenu_id() {
		return menu_id;
	}

	/**
	 * @param menu_id the menu_id to set
	 */
	public void setMenu_id(Long menu_id) {
		this.menu_id = menu_id;
	}

	/**
	 * @return the menu_classe
	 */
	public String getMenu_classe() {
		return menu_classe;
	}

	/**
	 * @param menu_classe the menu_classe to set
	 */
	public void setMenu_classe(String menu_classe) {
		this.menu_classe = menu_classe;
	}

	/**
	 * @return the menu_link
	 */
	public String getMenu_link() {
		return menu_link;
	}

	/**
	 * @param menu_link the menu_link to set
	 */
	public void setMenu_link(String menu_link) {
		this.menu_link = menu_link;
	}

	/**
	 * @return the menu_permissao
	 */
	public String getMenu_permissao() {
		return menu_permissao;
	}

	/**
	 * @param menu_permissao the menu_permissao to set
	 */
	public void setMenu_permissao(String menu_permissao) {
		this.menu_permissao = menu_permissao;
	}

	/**
	 * @return the menu_nome
	 */
	public String getMenu_nome() {
		return menu_nome;
	}

	/**
	 * @param menu_nome the menu_nome to set
	 */
	public void setMenu_nome(String menu_nome) {
		this.menu_nome = menu_nome;
	}

	/**
	 * @return the menu_parent
	 */
	public String getMenu_parent() {
		return menu_parent;
	}

	/**
	 * @param menu_parent the menu_parent to set
	 */
	public void setMenu_parent(String menu_parent) {
		this.menu_parent = menu_parent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", menu_classe=" + menu_classe
				+ ", menu_link=" + menu_link + ", menu_permissao="
				+ menu_permissao + ", menu_nome=" + menu_nome
				+ ", menu_parent=" + menu_parent + "]";
	}

	/**
	 * @param menu_classe
	 * @param menu_link
	 * @param menu_permissao
	 * @param menu_nome
	 * @param menu_parent
	 */
	public Menu(String menu_classe, String menu_link, String menu_permissao,
			String menu_nome, String menu_parent) {
		super();
		this.menu_classe = menu_classe;
		this.menu_link = menu_link;
		this.menu_permissao = menu_permissao;
		this.menu_nome = menu_nome;
		this.menu_parent = menu_parent;
	}

	public Menu() {
		super();
	}
	
	

}
