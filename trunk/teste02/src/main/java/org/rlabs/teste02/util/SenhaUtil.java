package org.rlabs.teste02.util;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import org.slf4j.Logger;

public class SenhaUtil implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private static Logger logger;

	public static String md5(String senha){  
        String sen = "";  
        MessageDigest md = null;  
        
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
        sen = hash.toString(16);   
        
        return sen;  
    }
	
	public static String sha256(String senha){
		//String senha = "123456";
		 
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md.update(senha.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
       logger.info("Hex format : " + sb.toString());
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	logger.info("Hex format : " + hexString.toString());
		
		return senha;
		
	}
}
