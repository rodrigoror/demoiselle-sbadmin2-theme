package org.rlabs.teste02.util;

/**
 * Classe para geracao e validacao de CPFs, util para testes
 * @author DTIM (copiado da internet)
 */
public class CpfUtil {
	
	
	/**
	 * Gera um CPF aleatorio (somente numeros) 
	 * @return String CPF (somente numeros)
	 */
	public static String geraCPF() {    
		String iniciais = "";    
		Integer numero;    
		for (int i = 0; i < 9; i++) {    
			numero = new Integer((int) (Math.random() * 10));    
			iniciais += numero.toString();    
		}    
		return iniciais + calcDigVerif(iniciais);    
	}  
	

	/**
	 * Valida um CPF (somente numeros)
	 * @param cpf String com somente os numeros (11 digitos)
	 * @return boolean se e valido
	 */
	public static boolean validaCPF(String cpf) {    
		if (cpf.length() != 11)    
			return false;    

		String numDig = cpf.substring(0, 9);    
		return calcDigVerif(numDig).equals(cpf.substring(9, 11));    
	}
	

	/**
	 * Retorna o digito verificador do CPF 
	 * @param num String CPF somente numeros (9 digitos)
	 * @return String com o digito verificador (2 caracteres)
	 */
	private static String calcDigVerif(String num) {    
		Integer primDig, segDig;    
		int soma = 0, peso = 10;    
		for (int i = 0; i < num.length(); i++)    
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;    

		if (soma % 11 == 0 | soma % 11 == 1)    
			primDig = new Integer(0);    
		else    
			primDig = new Integer(11 - (soma % 11));    

		soma = 0;    
		peso = 11;    
		for (int i = 0; i < num.length(); i++)    
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;    

		soma += primDig.intValue() * 2;    
		if (soma % 11 == 0 | soma % 11 == 1)    
			segDig = new Integer(0);    
		else    
			segDig = new Integer(11 - (soma % 11));    

		return primDig.toString() + segDig.toString();    
	}
	
	
	/**
	 * Formata um CPF
	 * @param cpfSomenteNumeros (11 digitos)
	 * @return
	 */
	public static String formataCpf(String cpfSomenteNumeros) {
		if (cpfSomenteNumeros.length() != 11)
			throw new RuntimeException("CPF deve ter 11 dígitos para usar a função de formatação!");
		String aux = cpfSomenteNumeros;
		return aux.substring(0, 3) + "." + 
				aux.substring(3, 6) + "." + 
				aux.substring(6, 9) + "-" + 
				aux.substring(9, 11);
	}

}
