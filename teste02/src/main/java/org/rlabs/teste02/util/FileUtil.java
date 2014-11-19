package org.rlabs.teste02.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
/*
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
*/
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * Classe auxiliar para operacoes com arquivos em disco 
 * @author equipe
 *
 */
public class FileUtil {

	
	/**
	 * Retorna os bytes de um arquivo existente no disco
	 * @param completeFileName Caminho completo ate o nome do arquivo
	 * @return Array com os bytes do arquivo
	 * @throws IOException
	 */
	public static byte[] readBytesFromFile(String completeFileName) throws IOException {
		File file = new File(completeFileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buf = new byte[(int)file.length()];
		in.read(buf);
		in.close();
		return buf;
		
		/* Se funcionasse com o o java.nio:
		Path path = Paths.get(completeFileName);
		byte[] data = Files.readAllBytes(path);
		return data;
		*/
	}
	
	
	/**
	 * Escreve os bytes de um arquivo para o disco, em um arquivo TEMPORARIO que sera DELETADO futuramente
	 * @param completeFileName Caminho completo ate o nome do arquivo
	 * @param fileBytes Array com os bytes do arquivo
	 * @throws IOException
	 */
	public static void writeBytesToTemporaryFile(String completeFileName, byte[] fileBytes) throws IOException {
		File file = new File(completeFileName);
		file.deleteOnExit(); // marca arquivo para delecao futura
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(fileBytes);
		fos.close();
	}
	

	/**
	 * Retorna um arquivo como um FileInputStream
	 * @param completeFileName Caminho completo ate o nome do arquivo
	 * @return
	 * @throws IOException
	 */
	public static FileInputStream readFileAsStream(String completeFileName) throws IOException {
		return new FileInputStream(completeFileName);
	}
	
	
	/**
	 * Escreve os bytes de um arquivo para o disco
	 * @param completeFileName Caminho completo ate o nome do arquivo
	 * @param fileBytes Array com os bytes do arquivo
	 * @throws IOException
	 */
	public static void writeBytesToFile(String completeFileName, byte[] fileBytes) throws IOException {
		FileOutputStream fos = new FileOutputStream(completeFileName);
		fos.write(fileBytes);
		fos.close();

		/* Se funcionasse com o java.nio:
		Path path = Paths.get(completeFileName);
		Files.write(path, fileBytes);
		*/
	}
	
	
	/**
	 * Retorna o hash SHA256 para um array de bytes
	 * @param fileBytes Array de bytes
	 * @return String do hash
	 * @throws NoSuchAlgorithmException
	 */
	public static String getFileHash(byte[] fileBytes) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(fileBytes);
		byte[] md5sum = digest.digest();
		BigInteger bigInt = new BigInteger(1, md5sum);
		return bigInt.toString(16);
	}
	
	
	/**
	 * Retorna o hash SHA256 para um arquivo no disco
	 * @param completeFileName Caminho completo ate o nome do arquivo
	 * @return String do hash
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String getFileHash(String completeFileName) throws NoSuchAlgorithmException, IOException {
		return getFileHash(readBytesFromFile(completeFileName));
	}
	
	
	/**
	 * Retorna o caminho absoluto para um caminho relativo
	 * @param relativeFilePath Caminho relativo (ex: "/images/brasao.gif")
	 * @return
	 */
	public static String getAbsoluteFilePath(String relativeFilePath) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext eContext = facesContext.getExternalContext();
		ServletContext servletContext = (ServletContext)eContext.getContext();
		String realPath = servletContext.getRealPath(relativeFilePath);
		return realPath;
	}
	

}
