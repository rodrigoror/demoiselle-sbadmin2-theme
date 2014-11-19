package org.rlabs.teste02.util;

/**
 * @author   rodrigo.ramos
 */
public enum EntidadeEnum {
	
	/* Cadastros basicos (colocar em ordem alfabetica) */
	CATEGORIA   	(10, "CATEGORIA"), 
	EQUIPE   		(15, "EQUIPE"), 
	FUNCAO 			(20, "FUNCAO"),
	MODALIDADE		(25, "MODALIDADE"),
	PARAMETROS		(30, "PARAMETROS"),
	PERFIL			(35, "PERFIL"),
	PESSOA			(40, "PESSOA"),
	PROGRAMA		(45, "PROGRAMA"),
	TIPO_DESPESA	(50, "TIPO_DESPESA"),
	USUARIO			(55, "USUARIO"),
	FAIXA_IR		(60, "FAIXA_IR"),
	
	/* Dados das equipes (colocar em ordem alfabetica) */
	PESSOA_EQUIPE	(100, "PESSOA_EQUIPE"),
	PESSOA_EQUIPE_DESPESA (105, "PESSOA_EQUIPE_DESPESA"),
	
	/* Fechamento de equipe (colocar em ordem alfabetica) */
	FECHAMENTO_EQUIPE (200, "FECHAMENTO_EQUIPE"),
	FECHAMENTO_EQUIPE_PESSOA (205, "FECHAMENTO_EQUIPE_PESSOA"),
	FECHAMENTO_EQUIPE_PESSOA_DESPESA (210, "FECHAMENTO_EQUIPE_PESSOA_DESPESA"),
	
	/* Pagamento (colocar em ordem alfabetica) */
	PAGAMENTO (300, "PAGAMENTO");
	
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
