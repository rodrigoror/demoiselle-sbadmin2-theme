package org.rlabs.teste02.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Classe utilitaria para operacoes em datas.
 * 
 * @author d333379
 * 
 */
public class DateUtil {
	/**
	 * Fomato do Pattern padrao para data no sistema.
	 */
	public static final String FORMATO_DATA_PADRAO = "dd/MM/yyyy";


	/**
	 * Adiciona uma quantidade de dias na data.
	 * 
	 * @param dias
	 * @param data
	 * @return A data com a quantidade de dias adicionados
	 */
   public static final Date adicionaDias(int dias, Date data)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(6, dias);
        return calendar.getTime();
    }


	/**
	 * Verifica se a data inicial e maior que a data final. Se pelo menos uma
	 * das datas for null, retorna true.
	 * 
	 * @param dtInicio
	 * @param dtFim
	 * @return
	 */
	public static boolean isDataInicialMaiorQueFinal(Date dtInicio, Date dtFim) {
		if (dtInicio == null || dtFim == null)
			return true;

		// Critica se data inicial e maior que a data final.
		if (dtInicio.after(dtFim)) {
			return true;
		}
		return false;
	}

	/**
	 * Verifica se a data final e maior que a data atual. Se a data final for
	 * null, retorna true.
	 * 
	 * @param dtFim
	 * @return
	 */
	public static boolean isDataFinalMaiorQueAtual(Date dtFim) {
		if (dtFim == null)
			return true;

		// Critica se data final e maior que a data atual.
		if (dtFim.after(new Date())) {
			return true;
		}
		return false;
	}

	/**
	 * Verifica se a data inicial e anterior a data atual mais do que a
	 * quantidade de meses passada por parametro. Se a data inicial for null,
	 * retorna true.
	 * 
	 * @param dtInicio
	 * @param meses
	 * @return
	 */
	public static boolean isDataInicialAnterior(Date dtInicio, int meses) {
		if (meses <= 0)
			return true;

		Calendar calendario = new GregorianCalendar();
		calendario.setTime(dtInicio);
		calendario.add(GregorianCalendar.MONTH, meses);
		calendario.add(GregorianCalendar.DAY_OF_MONTH, 1);
		if (calendario.getTime().before(new Date()))
			return true;
		return false;
	}

	/**
	 * Verifica se a data inicial e anterior a data final mais do que a
	 * quantidade de dias passado por parametro. Se a data inicial for null,
	 * retorna true.
	 * 
	 * @param dtInicio
	 * @param meses
	 * @return
	 */
	public static boolean isDiferencaDatasInferiorXDias(Date dtInicio, Date dtFim, int dias) {
		if (dias <= 0)
			return true;

		Calendar calendario = new GregorianCalendar();
		calendario.setTime(dtInicio);
		calendario.add(GregorianCalendar.DAY_OF_MONTH, dias);
		if (calendario.getTime().before(dtFim))
			return true;
		return false;
	}

	/**
	 * Esse metodo recebe uma String representando uma data no formato utilizado
	 * no Brasil (dd/MM/yyyy) e retorna um objeto <code>java.util.Date</code>
	 * representativo dessa mesma data.
	 *
	 * A informacao de dia e mes pode conter um ou dois digitos.
	 *
	 * @return java.util.Date representando a data informada como String.
	 *         Retorna <code>null</code> se a data for <code>null</code>.
	 * @param data
	 *            - data a ser reformatada.
	 * @throw IllegalArgumentException - se a data nao representar um formato de
	 *        datas utilizado no Brasil ou nao representar uma data valida.
	 */
	public static Date parseString2Date(String data) {
		Date retorno = null;

		if ((data == null) || (data.trim().equals(""))) {
			return retorno;
		}

		DateFormat df = new SimpleDateFormat(FORMATO_DATA_PADRAO);
		df.setLenient(false);
		try {
			retorno = df.parse(data);
		} catch (ParseException e) {
			throw new IllegalArgumentException("A data [" + data
					+ "] não representa uma data válida!");
		}
		return retorno;
	}

	/**
	 * Esse metodo recebe um objeto <code>java.util.Date</code> representando
	 * uma data obtida no banco de dados e retorna a representacao dessa data em
	 * String no formato de data utilizada no Brasil (dd/MM/yyyy).
	 *
	 * @return String representando a data no formato brasileiro (dd/MM/yyyy).
	 *         Retorna <code>null</code> se a data for <code>null</code>.
	 * @param data
	 *            - data a ser reformatada.
	 */
	public static String parseDate2String(final Date data) {

		String retorno = null;

		if (data == null) {
			return retorno;
		}

		DateFormat df = new SimpleDateFormat(FORMATO_DATA_PADRAO);
		retorno = df.format(data);

		return retorno;
	}

	/**
	 * Valida se a data inicial e inferior a 10 anos da data atual Se a data
	 * inicial for inferir a data atual retorna 'true'
	 * 
	 * @param dataInicio
	 *            tipo String
	 * 
	 */
	public static boolean isDataInicialInferior10Anos(String dataInicio) {
		int anos = 10;
		Date dtAtual = new Date();
		Date dtInicio = parseString2Date(dataInicio);
		// System.out.println("Data Atual: " + dtAtual);

		// DataLimite (10 anos antes da atual)
		return isDiferencaDatasInferiorXAnos(dtInicio, dtAtual, anos);
	}

	/**
	 * Valida se a diferenca entre as datas e menor que o intervalo em anos informado.
	 * @param dataInicio Data de inicio do intervalo
	 * @param dataFim Data finaL do intervalo
	 * @param anos Numero de anos do intervalo (Positivo)
	 * @return
	 */
	public static boolean isDiferencaDatasInferiorXAnos(Date dataInicio, Date dataFim, int anos) {
		Calendar cLimite = Calendar.getInstance();
		cLimite.setTime(dataFim);
		cLimite.add(Calendar.YEAR, -anos);
		Date dtLimite = cLimite.getTime();

		// data inicial tem X anos ou mais da data atual
		if (dataInicio.before(dtLimite)) {
			return false;
		} else {// Data inicio tem menos de X anos da data atual
			return true;
		}
	}

	// private static void validarData(String data)
	// {
	// if (!(Pattern.matches("\\d\\d?/\\d\\d?/\\d\\d\\d\\d", data)))
	// throw new IllegalArgumentException("A data [" + data +
	// "] não representa um formato válido!");
	// }

	/**
	 * Retorna a data inicial minima (formato dd/mm/yyyy) em relacao a data
	 * atual de acordo com a quantidade de meses passada por parametro. Util
	 * para limitar a data minima no componente de calendario.
	 * 
	 * @param meses
	 * @return
	 */
	public static String getDataMinima(int meses) {
		if (meses <= 0)
			return "";

		Calendar calendario = new GregorianCalendar();
		calendario.add(GregorianCalendar.MONTH, -meses);
		return new SimpleDateFormat(FORMATO_DATA_PADRAO).format(calendario.getTime());

	}

	/**
	 * Valida se a data inicial e inferior a 2 anos da data final Se a data
	 * inicial for inferir a data final retorna 'true'
	 * 
	 * @param dataInicio
	 *            tipo String
	 * @param dataFim
	 *            tipo String
	 */
	public static boolean isDataInicialFinalMaior2Anos(String dataInicio, String dataFim) {

		Date dtInicio = parseString2Date(dataInicio);
		Date dtFim = parseString2Date(dataFim);

		// DataLimite (2 anos antes da final)
		Calendar cLimite = Calendar.getInstance();
		cLimite.setTime(dtInicio);
		cLimite.add(Calendar.YEAR, 2);
		Date dtLimite = cLimite.getTime();
		// data inicial maior de 2 anos da data final
		if (dtLimite.before(dtFim)) {
			return false;
		} else {// Data inicio tem 2 anos ou menos da data atual
			return true;
		}
	}

	public DateUtil() {
		super();
	}

	/**
	 * Valida se a data esta no formato correto (dd/mm/aaaa) Se a data esta no
	 * formato correto retorna 'true'
	 * 
	 * @param data
	 *            tipo String
	 * @param nomeCampo
	 *            tipo String
	 */
	public static boolean validarData(String data, String nomeCampo) {

		// Nao escolheu opcao valida
		if (data == null || data.equals("")) {
			MensagemUtil.exibirMsgErro(nomeCampo + " é obrigatório(a)");
			return false;
		}
		// Verifica se a data informada pelo usuario esta no formato correto
		// (dd/MM/yyyy)
		if (!(Pattern.matches("\\d\\d?/\\d\\d?/\\d\\d\\d\\d", data))) {
			MensagemUtil.exibirMsgErro(nomeCampo +" inválido(a)");
			return false;
		}

		return true;
	}
	
	/**
	 * Pega o ano corrente
	 */
	public static Integer getAnoCorrente(){
		Date hoje  = new Date();
		SimpleDateFormat ano = new SimpleDateFormat("yyyy");
		return Integer.parseInt(ano.format(hoje));
	}
	
	/**
	 * pega o mes Corrente
	 * @return
	 */
	public static Integer getMesCorrente(){
		Date hoje  = new Date();
		SimpleDateFormat mes = new SimpleDateFormat("MM");
		return Integer.parseInt(mes.format(hoje));
	}
	
	/**
	 * pega o dia Corrente
	 * @return
	 */
	public static Integer getDiaCorrente(){
		Date hoje  = new Date();
		SimpleDateFormat dia = new SimpleDateFormat("dd");
		return Integer.parseInt(dia.format(hoje));
	}
	
	
	/**
	 * Retorna string da data e hora corrente no formato dd/MM/yyyy HH:mm
	 * @return
	 */
	public static String getDataHoraCorrente() {
		Date hoje  = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.format(hoje);
	}
	
	
	/**
	 * Devolve o Nome do Mes
	 * @param int mes
	 */
	public static String getNomeMes(int mes){
		switch (mes) {
		case 1:	return "Janeiro";
		case 2:return "Fevereiro";
		case 3:return "Março";
		case 4:return "Abril";
		case 5:return "Maio";
		case 6:return "Junho";
		case 7:return "Julho";
		case 8:return "Agosto";
		case 9:return "Setembro";
		case 10:return "Outubro";
		case 11:return "Novembro";
		case 12:return "Dezembro";
		default:
			return "";
		}
	}
	
	/**
	 * Retorna uma lista dos meses do ano
	 * @return LinkedHashMap com nome e numero dos meses
	 */
	public static Map<String, Integer> getListaDeMeses() {
		Map<String, Integer> meses = new LinkedHashMap<String, Integer>();
		meses.put("Janeiro", 1);
		meses.put("Fevereiro", 2);
		meses.put("Março", 3);
		meses.put("Abril", 4);
		meses.put("Maio", 5);
		meses.put("Junho", 6);
		meses.put("Julho", 7);
		meses.put("Agosto", 8);
		meses.put("Setembro", 9);
		meses.put("Outubro", 10);
		meses.put("Novembro", 11);
		meses.put("Dezembro", 12);
		return meses;
	}
	
	/**
	 * Retorna uma lista dos meses do ano a partir do atual ate dezembro
	 * @return LinkedHashMap com nome e numero dos meses
	 */
	public static Map<String, Integer> getListaDeMesesDoAtual() {
		Map<String, Integer> meses = new LinkedHashMap<String, Integer>();
		int mesAtual = getMesCorrente();
		for (int i = mesAtual; i <= 12; i++) {
			meses.put(getNomeMes(i), i);
		}
		return meses;
	}

}
