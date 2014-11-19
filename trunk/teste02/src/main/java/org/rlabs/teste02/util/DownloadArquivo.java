	package org.rlabs.teste02.util;

	import java.io.File;  
	import java.io.FileInputStream;  
	import java.io.IOException;  
	import java.io.OutputStream;  
	import javax.faces.context.ExternalContext;  
	import javax.faces.context.FacesContext;  
	import javax.servlet.http.HttpServletResponse; 

	/**
	 * Classe para realizar download do arquivo txt.
	 * 
	 * @author bruno.cristiano
	 * 
	 */
public class DownloadArquivo {
	/**
	 * Gera download do arquivo txt salvo no disco .
	 * 
	 * @param arquivo txt gerado
	 * @param path do arquivo
     * @param tipo de arquivo. EX: txt, pdf
	 * @return download do arquivo no browser
	 */
	 public static synchronized void downloadFile(String filename, String fileLocation, String mimeType, FacesContext facesContext) { 
		 ExternalContext context = facesContext.getExternalContext(); // Context  
	        String path = fileLocation; // path de localizacao do arquivo  
	        //String fullFileName = path + filename;  
	        File file = new File(path); // Objeto arquivo com nome do caminho do arquivo
	  
	        HttpServletResponse response = (HttpServletResponse) context.getResponse();  
	        response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\""); //seta header e nome do arquivo que aparece na tela de download 
	        response.setContentLength((int) file.length()); // lenght do arquivo  
	        response.setContentType(mimeType); // tipo de arquivo para download - EX: "txt"  
	  
	        
	        try {  
	        	//leitura do arquivo 
	            FileInputStream in = new FileInputStream(file);  
	            OutputStream out = response.getOutputStream();  
	  
	            byte[] buf = new byte[(int)file.length()];  
	            int count;  
	            while ((count = in.read(buf)) >= 0) {  
	                out.write(buf, 0, count);  
	            }  
	            in.close();  
	            out.flush();  
	            out.close();  
	        facesContext.responseComplete();  
	        } catch (IOException ex) {  
	            System.out.println("Erro no download do arquivo: " + ex.getMessage());  
	            ex.printStackTrace();  
	        }  
	 }
}
