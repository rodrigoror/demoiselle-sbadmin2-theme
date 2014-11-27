package org.rlabs.teste02.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Recebe um valor integer e retorna uma string com o valor por extenso
 * @author rodrigo.ramos
 * @see https://github.com/jau/porextenso
 */
public class IntegerWriterUtil {
	/**
	 * Nomes das grandezas numericas no plural. O mapa a chave do mapa e o
	 * expoente de dez do numero e o valor e o seu nome no plural. Por exemplo:
	 * para chave 3 (10^3) o valor e "mil", para a chave 6 (10^6) o valor e
	 * "milhoes", e assim por diante. Os nomes foram obtidos de um artigo
	 * publicado na secao Dois Mais Dois na revista SuperInteressante no. 15, de
	 * dezembro de 1988 (Editora Abril, Sao Paulo/SP), disponivel em
	 * http://www.novomilenio.inf.br/idioma/19881200.htm.
	 */
	private final Map<Integer, String> grandezasPlural = new HashMap<Integer, String>();
	private final Map<Integer, String> grandezasSingular = new HashMap<Integer, String>();

	/** Nomes dos numeros. */
	private final Map<Integer, String> nomes = new HashMap<Integer, String>();

	//private static final String PARTICULA_ADITIVA = "e";
	//private static final String PARTICULA_DESCRITIVA = "de";

	
	public IntegerWriterUtil() {
		preencherGrandezasPlural();
		preencherGrandezasSingular();
		preencherNomes();
	}

	public String write(Integer amount) {
		//TODO OK - implementar o restante para retornar qualquer numero inteiro por extenso, hoje retorna somente ate 20
		if(amount < 20){
			return nomes.get(amount);
		}else{
			return "Erro(Max é 20 cotas)";
		}
	}

	private void preencherGrandezasPlural() {
		grandezasPlural.put(3, "mil");
		grandezasPlural.put(6, "milhões");
		grandezasPlural.put(9, "bilhões");
		grandezasPlural.put(12, "trilhões");
		grandezasPlural.put(15, "quatrilhões");
		grandezasPlural.put(18, "quintilhões");
		grandezasPlural.put(21, "sextilhões");
		grandezasPlural.put(24, "setilhões");
	}

	private void preencherGrandezasSingular() {
		grandezasSingular.put(3, "mil");
		grandezasSingular.put(6, "milhão");
		grandezasSingular.put(9, "bilhão");
		grandezasSingular.put(12, "trilhão");
		grandezasSingular.put(15, "quatrilhão");
		grandezasSingular.put(18, "quintilhão");
		grandezasSingular.put(21, "sextilhão");
		grandezasSingular.put(24, "setilhão");
	}

	private void preencherNomes() {
		nomes.put(1, "um");
		nomes.put(2, "dois");
		nomes.put(3, "três");
		nomes.put(4, "quatro");
		nomes.put(5, "cinco");
		nomes.put(6, "seis");
		nomes.put(7, "sete");
		nomes.put(8, "oito");
		nomes.put(9, "nove");
		nomes.put(10, "dez");
		nomes.put(11, "onze");
		nomes.put(12, "doze");
		nomes.put(13, "treze");
		nomes.put(14, "quatorze");
		nomes.put(15, "quinze");
		nomes.put(16, "dezesseis");
		nomes.put(17, "dezessete");
		nomes.put(18, "dezoito");
		nomes.put(19, "dezenove");
		nomes.put(20, "vinte");
		nomes.put(30, "trinta");
		nomes.put(40, "quarenta");
		nomes.put(50, "cinquenta");
		nomes.put(60, "sessenta");
		nomes.put(70, "setenta");
		nomes.put(80, "oitenta");
		nomes.put(90, "noventa");
		nomes.put(200, "duzentos");
		nomes.put(300, "trezentos");
		nomes.put(400, "quatrocentos");
		nomes.put(500, "quinhentos");
		nomes.put(600, "seiscentos");
		nomes.put(700, "setecentos");
		nomes.put(800, "oitocentos");
		nomes.put(900, "novecentos");
	}
}
