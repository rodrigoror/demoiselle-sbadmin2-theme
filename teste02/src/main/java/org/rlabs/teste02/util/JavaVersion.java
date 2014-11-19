package org.rlabs.teste02.util;

import java.util.Properties;

public class JavaVersion {

	
	/**
	 * Retorna a versao do Java, da VM e JRE
	 * @return
	 */
	public static String getJavaVersion() {
		
		String[] pro = {"java.version", "java.vm.version", "java.runtime.version"};

		Properties properties = System.getProperties();
		
		String versao = "";
		
		for (int i = 0; i < pro.length; i++) {
			if (!versao.equals(""))
				versao += "; ";
			versao += pro[i] + ": ";
			versao += properties.getProperty(pro[i]);
		}
		
		return versao;
	}

}
