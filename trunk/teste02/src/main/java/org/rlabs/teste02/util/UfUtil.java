package org.rlabs.teste02.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class UfUtil {

	/**
	 * Retorna uma lista das UFs do Brasil
	 * @return LinkedHashMap com nome e sigla das UFs
	 */
	public static Map<String, String> getListaDeUfs() {
		Map<String, String> ufs = new LinkedHashMap<String, String>();
		ufs.put("São Paulo", "SP");
		ufs.put("Acre", "AC");
		ufs.put("Alagoas", "AL");
		ufs.put("Amazonas", "AM");
		ufs.put("Amapá", "AP");
		ufs.put("Bahia", "BA");
		ufs.put("Ceará", "CE");
		ufs.put("Distrito Federal", "DF");
		ufs.put("Espírito Santo", "ES");
		ufs.put("Goiás", "GO");
		ufs.put("Maranhão", "MA");
		ufs.put("Minas Gerais", "MG");
		ufs.put("Mato Grosso do Sul", "MS");
		ufs.put("Mato Grosso", "MT");
		ufs.put("Pará", "PA");
		ufs.put("Paraíba", "PB");
		ufs.put("Pernambuco", "PE");
		ufs.put("Piauí", "PI");
		ufs.put("Paraná", "PA");
		ufs.put("Rio de Janeiro", "RJ");
		ufs.put("Rio Grande do Norte", "RN");
		ufs.put("Rondônia", "RO");
		ufs.put("Roraima", "RR");
		ufs.put("Rio Grande do Sul", "RS");
		ufs.put("Santa Catarina", "SC");
		ufs.put("Sergipe", "SE");
		ufs.put("Tocantins", "TO");
		return ufs;
	}

}
