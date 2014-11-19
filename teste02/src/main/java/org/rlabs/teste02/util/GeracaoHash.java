package org.rlabs.teste02.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe Util para geracao de hash do arquivo .
 * 
 * @author bruno.cristiano
 * 
 */

public class GeracaoHash {
	/**
	 * Adiciona uma quantidade de dias na data.
	 * 
	 * @param arquivo txt gerado
	 * @return o HASH do arquivo
	 */
	public static String geraHash(File f) throws NoSuchAlgorithmException, FileNotFoundException{  
		MessageDigest digest = MessageDigest.getInstance("MD5");  
		InputStream is = new FileInputStream(f);                  
		byte[] buffer = new byte[8192];  
		int read = 0;  
		String output = null;  
		try {  
			while( (read = is.read(buffer)) > 0) {  
				digest.update(buffer, 0, read);  
			}         
			byte[] md5sum = digest.digest();  
			BigInteger bigInt = new BigInteger(1, md5sum);  
			output = bigInt.toString(16); 
			File file = new File("d:\\HashPagamento.txt");  
			PrintWriter pw = new PrintWriter(file); 
			pw.printf(output);
			pw.flush();  
			pw.close(); 
		}  
		catch(IOException e) {  
			throw new RuntimeException("Não foi possivel gerar download o arquivo.", e);
		}  
		finally {  
			try {  
				is.close();  
			}  
			catch(IOException e) {  
				throw new RuntimeException("Não foi possivel fechar o arquivo", e); 
			}  
		}     
		return output;  
	}  
}
