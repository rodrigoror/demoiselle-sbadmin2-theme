package org.rlabs.teste02.util;

/**
 * 
 * @author claudio.luiz
 * Classe para completar com letras ou numeros, a direita ou esquerda.
 */

public class PreencheUtil {
	
	/**
	 * 
	 * Funcao para preencher com caracteres ou numeros. 
	 * Parametros:  linha_a_preencher: Texto ou valor que deve ser completado. String
	 * 				letra: Letra ou numero que sera repetido para preencher.
	 * 				tamanho: Quantidade total da string, deve ser maior que o tamanho da linha_a_preencher.
	 * 				direcao: Lado para o qual sera repetido os caracteres. e - esquerda e d - direita
	 */
	
	public static String preencheCom(String linha_a_preencher, String letra, int tamanho, String direcao) {
	
	    //Checa se Linha a preencher e nula ou branco
	    if (linha_a_preencher == null || linha_a_preencher.trim() == "" ) {linha_a_preencher = "";}
	    StringBuffer sb = new StringBuffer(linha_a_preencher);

	    if (sb.length() < tamanho){
	
		    if (direcao == "e"){ //a Esquerda
		        for (int i=sb.length() ; i<tamanho ; i++){
		            sb.insert(0,letra);
		        }
		    } else if (direcao == "d") {//a Direita
		        for (int i=sb.length() ; i<tamanho ; i++){
		            sb.append(letra);
		        }
		    }
	    }
	
	    return sb.toString();
	}
}
