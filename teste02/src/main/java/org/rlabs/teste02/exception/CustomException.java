package org.rlabs.teste02.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  rodrigo.ramos
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="excecoes"
	 */
	private List<Excecao> excecoes;

	public CustomException() {
		excecoes = new ArrayList<Excecao>();
	}

	public CustomException(String mensagem, Object... parametros) {
		this();
		adicionarMensagem(mensagem, parametros);
		
	}

	public void adicionarMensagem(String mensagem, Object... parametros) {
		excecoes.add(new Excecao(mensagem, parametros));
	}

	/**
	 * @return
	 * @uml.property  name="excecoes"
	 */
	public List<Excecao> getExcecoes() {
		return excecoes;
	}

}
