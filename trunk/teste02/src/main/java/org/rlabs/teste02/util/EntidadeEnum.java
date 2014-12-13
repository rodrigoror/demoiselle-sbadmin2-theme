package org.rlabs.teste02.util;

/**
 * @author   rodrigo.ramos
 */
public enum EntidadeEnum {
	
	/* Cadastros basicos (colocar em ordem alfabetica) */
	BOOKMARK		(100, "BOOKMARK"),
	COMPANY 	   	(200, "COMPANY"), 
	COMPANYEND   	(300, "COMPANYEND"),
	INICIALIZADOR	(400, "INICIALIZADOR"),
	MENU 			(500, "MENU"),
	PERFIL			(600, "PERFIL"),
	SUBMENU			(700, "SUBMENU"),
	USERS			(800, "USERS");
	
	private Integer id;
	
	private String descricao;
	
	
	private EntidadeEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
