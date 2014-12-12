/**
 * 
 */
package org.rlabs.teste02.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Classe que identifica o submenu
 * @author rodrigo.ramos
 */
@Entity
@Table(name="SUBMENU"/*, schema="schema"*/)
public class SubMenu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name="smen_id")
	private Long smen_id;
	
	@Column(name="smen_link", nullable=false)
	@Length(max=100)
	@NotNull
	private String smen_link;
	
	@Column(name="smen_permissao", nullable=false)
	@Length(max=100)
	@NotNull
	private String smen_permissao;
	
	@Column(name="smen_nome", nullable=false)
	@Length(max=25)
	@NotNull
	private String smen_nome;
	
	@Column(name="smen_parent")
	@Length(max=10)
	private String smen_parent;
	
	@ManyToOne
    @JoinColumn(name="menu_id", nullable=false)	
	private Menu smen_menu;

	/**
	 * @return the smen_id
	 */
	public Long getSmen_id() {
		return smen_id;
	}

	/**
	 * @param smen_id the smen_id to set
	 */
	public void setSmen_id(Long smen_id) {
		this.smen_id = smen_id;
	}

	/**
	 * @return the smen_link
	 */
	public String getSmen_link() {
		return smen_link;
	}

	/**
	 * @param smen_link the smen_link to set
	 */
	public void setSmen_link(String smen_link) {
		this.smen_link = smen_link;
	}

	/**
	 * @return the smen_permissao
	 */
	public String getSmen_permissao() {
		return smen_permissao;
	}

	/**
	 * @param smen_permissao the smen_permissao to set
	 */
	public void setSmen_permissao(String smen_permissao) {
		this.smen_permissao = smen_permissao;
	}

	/**
	 * @return the smen_nome
	 */
	public String getSmen_nome() {
		return smen_nome;
	}

	/**
	 * @param smen_nome the smen_nome to set
	 */
	public void setSmen_nome(String smen_nome) {
		this.smen_nome = smen_nome;
	}

	/**
	 * @return the smen_parent
	 */
	public String getSmen_parent() {
		return smen_parent;
	}

	/**
	 * @param smen_parent the smen_parent to set
	 */
	public void setSmen_parent(String smen_parent) {
		this.smen_parent = smen_parent;
	}

	/**
	 * @return the smen_menu
	 */
	public Menu getSmen_menu() {
		return smen_menu;
	}

	/**
	 * @param smen_menu the smen_menu to set
	 */
	public void setSmen_menu(Menu smen_menu) {
		this.smen_menu = smen_menu;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubMenu [smen_id=" + smen_id 
				+ ", smen_link=" + smen_link + ", smen_permissao="
				+ smen_permissao + ", smen_nome=" + smen_nome
				+ ", smen_parent=" + smen_parent + ", smen_menu=" + smen_menu.getMenu_nome()
				+ "]";
	}

	/**
	 * Construtor
	 */
	public SubMenu() {
		super();
	}

	/**
	 * @param smen_link
	 * @param smen_permissao
	 * @param smen_nome
	 * @param smen_parent
	 * @param smen_menu
	 */
	public SubMenu(String smen_link, String smen_permissao,
			String smen_nome, String smen_parent, Menu smen_menu) {
		super();
		this.smen_link = smen_link;
		this.smen_permissao = smen_permissao;
		this.smen_nome = smen_nome;
		this.smen_parent = smen_parent;
		this.smen_menu = smen_menu;
	}
	
	
}
