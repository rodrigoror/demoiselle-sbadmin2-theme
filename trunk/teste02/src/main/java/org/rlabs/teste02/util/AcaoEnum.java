package org.rlabs.teste02.util;

/**
 * @author   rodrigo.ramos
 */
public enum AcaoEnum {

	CADASTROU (1, "CADASTROU"), 
	EXCLUIU   (2, "EXCLUIU"), 
	ALTEROU   (3, "ALTEROU"), 
	CONSULTOU (4, "CONSULTOU"),
	LOGOU     (5, "LOGOU");

	private Integer id;

	private String descricao;

	
	/**
	 * Construtor
	 * @param id
	 * @param descricao
	 */
	private AcaoEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	

	/**
	 * Metodos Get's and Set's
	 * @return
	 * @uml.property  name="id"
	 */
	public Integer getId() {
		return id;
	}
	
	
	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	/**
	 * @return
	 * @uml.property  name="descricao"
	 */
	public String getDescricao() {
		return descricao;
	}
	
	
	/**
	 * @param descricao
	 * @uml.property  name="descricao"
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
