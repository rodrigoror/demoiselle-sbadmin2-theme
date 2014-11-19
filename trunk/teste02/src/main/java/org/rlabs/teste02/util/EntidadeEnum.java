package org.rlabs.teste02.util;

/**
 * @author   rodrigo.ramos
 */
public enum EntidadeEnum {
	
	/* Cadastros basicos (colocar em ordem alfabetica) */
	COMPANY 	   	(10, "COMPANY"), 
	COMPANYEND   	(15, "COMPANYEND"), 
	MENU 			(20, "MENU"),
	PERFIL			(35, "PERFIL"),
	SUBMENU			(40, "SUBMENU"),
	USERS			(45, "USERS");
	
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
