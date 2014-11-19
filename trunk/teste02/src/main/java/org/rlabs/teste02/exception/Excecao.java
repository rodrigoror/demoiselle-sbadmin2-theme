package org.rlabs.teste02.exception;

/**
 * @author  rodrigo.ramos
 */
public class Excecao {
	
	/**
	 * @uml.property  name="mensagem"
	 */
	private String mensagem;

	/**
	 * @uml.property  name="parametros"
	 */
	private Object parametros[];

	/**
	 * @return
	 * @uml.property  name="mensagem"
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem
	 * @uml.property  name="mensagem"
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	/**
	 * @return
	 * @uml.property  name="parametros"
	 */
	public Object[] getParametros() {
		return parametros;
	}

	/**
	 * @param parametros
	 * @uml.property  name="parametros"
	 */
	public void setParametros(Object[] parametros) {
		this.parametros = parametros;
	}

	public Excecao(String mensagem, Object[] parametros) {
		super();
		this.mensagem = mensagem;
		this.parametros = parametros;
		
	}
	
	
}
