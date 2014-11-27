package org.rlabs.teste02.config;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.configuration.Configuration;

/**
 * Configuracoes do projeto FADENP
 * @author equipe
 * @see http://demoiselle.sourceforge.net/docs/framework/reference/2.3.4/html/configuracao.html#d0e668
 */
@Configuration(resource="fadenp")
public class Teste02Config {

	@Name("email.remetente")
	private String emailRemetente;
	
	@Name("arquivo.memorando.correntistas")
	private String arquivoMemorandoCorrentistas;

	@Name("arquivo.memorando.naocorrentistas")
	private String arquivoMemorandoNaoCorrentistas;
	
	@Name("arquivo.relatorio.correntistas")
	private String arquivoRelatorioCorrentistas;

	@Name("arquivo.relatorio.naocorrentistas")
	private String arquivoRelatorioNaoCorrentistas;
	
	@Name("arquivo.relatorio.aditivos")
	private String arquivoRelatorioAditivos;
	
	@Name("arquivo.txt")
	private String arquivoTxt;
	
	@Name("banco.numero.santander")
	private String numeroBancoSantander;
	
	@Name("teste.debugger")
	private String modoDebugger;
	
	@Name("https.usar")
	private String usarHttps;
	
	@Name("https.porta.segura")
	private String portaHttps;
	
	@Name("https.porta.insegura")
	private String portaHttp;
	
	@Name("fechamentodesfazer.limite")
	private String desfazerLimite;
	
	/**
	 * Retorna o DIA limite para desfazer o Fechamento
	 * @return
	 */
	public Integer getDesfazerLimite() {
		return Integer.valueOf(this.desfazerLimite);
	}
	
	/**
	 * Retorna o endereco de e-mail padrao utilizado como remetente das mensagens
	 * @return
	 */
	public String getEmailRemetente() {
		return this.emailRemetente;
	}
	
	
	/**
	 * Retorna o caminho completo do arquivo do memorando de correntistas no disco (servidor) para um determinado ID de pagamento
	 * @param idPagamento: ID do pagamento
	 * @return
	 */
	public String getNomeArquivoMemorandoCorrentistas(Long idPagamento, String sPrograma) {
		return String.format(this.arquivoMemorandoCorrentistas, idPagamento.toString(), sPrograma);
	}

	
	/**
	 * Retorna o caminho completo do arquivo do memorando de NAO correntistas no disco (servidor) para um determinado ID de pagamento
	 * @param idPagamento: ID do pagamento
	 * @return
	 */
	public String getNomeArquivoMemorandoNaoCorrentistas(Long idPagamento, String sPrograma) {
		return String.format(this.arquivoMemorandoNaoCorrentistas, idPagamento.toString(), sPrograma);
	}
	
	
	/**
	 * Retorna o caminho completo do arquivo do relatorio de correntistas no disco (servidor) para um determinado ID de pagamento
	 * @param idPagamento: ID do pagamento
	 * @return
	 */
	public String getNomeArquivoRelatorioCorrentistas(Long idPagamento, String sPrograma) {
		return String.format(this.arquivoRelatorioCorrentistas, idPagamento.toString(), sPrograma);
	}

	
	/**
	 * Retorna o caminho completo do arquivo do relatorio de NAO correntistas no disco (servidor) para um determinado ID de pagamento
	 * @param idPagamento: ID do pagamento
	 * @return
	 */
	public String getNomeArquivoRelatorioNaoCorrentistas(Long idPagamento, String sPrograma) {
		return String.format(this.arquivoRelatorioNaoCorrentistas, idPagamento.toString(), sPrograma);
	}
	
	
	/**
	 * Retorna o caminho completo do arquivo do relatorio de aditivos no disco (servidor) para um determinado ID de pagamento
	 * @return the arquivoRelatorioAditivos
	 */
	public String getNomeArquivoRelatorioAditivos(Long idPagamento) {
		return String.format(this.arquivoRelatorioAditivos, idPagamento.toString());
	}


	/**
	 * Retorna o caminho completo do arquivo TXT no disco (servidor) para um determinado ID de pagamento
	 * @param idPagamento: ID do pagamento
	 * @return
	 */
	public String getNomeArquivoTxt(Long idPagamento) {
		return String.format(this.arquivoTxt, idPagamento.toString());
	}
	
	
	/**
	 * Retorna o numero do banco Santander
	 * @return
	 */
	public Integer getNumeroBancoSantander() {
		return Integer.parseInt(this.numeroBancoSantander);
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
