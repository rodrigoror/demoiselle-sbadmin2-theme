package org.rlabs.teste02.config;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.configuration.Configuration;

/**
 * Configuracoes do projeto
 * @author Equipe
 * @see http://demoiselle.sourceforge.net/docs/framework/reference/2.3.4/html/configuracao.html#d0e668
 */
@Configuration(resource="teste02", prefix = "general")
public class Teste02Config {

	@Name("email.remetente")
	private String emailRemetente;
	
	@Name("teste.debugger")
	private String modoDebugger;
	
	@Name("https.usar")
	private String usarHttps;
	
	@Name("https.porta.segura")
	private String portaHttps;
	
	@Name("https.porta.insegura")
	private String portaHttp;
	
	/**
	 * Retorna o endereco de e-mail padrao utilizado como remetente das mensagens
	 * @return
	 */
	public String getEmailRemetente() {
		return this.emailRemetente;
	}
	
		
	/**
	 * Retorna se a aplicacao deve rodar em modo debugger.
	 * Em modo debugger gera dados de teste no InicializadorBC, etc.
	 * @return
	 */
	public boolean isModoDebugger() {
		return (this.modoDebugger.toUpperCase().trim().equals("S"));
	}
	

	/**
	 * Retorna se a aplicacao deve usar HTTPS
	 * @return
	 */
	public boolean usarHttps() {
		return (this.usarHttps.toUpperCase().trim().equals("S"));
	}
	
	
	/**
	 * Retorna a porta para usar em caso de HTTPS
	 * @return
	 */
	public String portaHttps() {
		return this.portaHttps;
	}
	
	
	/**
	 * Retorna a porta usada em caso de NAO usar HTTPS
	 * @return
	 */
	public String portaHttp() {
		return this.portaHttp;
	}


}
