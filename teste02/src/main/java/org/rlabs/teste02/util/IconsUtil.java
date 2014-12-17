/**
 * 
 */
package org.rlabs.teste02.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author rodrigo.ramos
 * @see http://fortawesome.github.io/Font-Awesome/icons/
 */
public class IconsUtil {
	
	/**
	 * Retorna uma lista das Classes dos Icones
	 * @return LinkedHashMap a classe completa do Icone
	 */
	public static Map<String, String> getWebApplicationIcons() {
		Map<String, String> retorno = new LinkedHashMap<String, String>();
		retorno.put("fa fa-dashboard fa-fw", "fa fa-dashboard fa-fw");
		retorno.put("fa fa-cloud-upload fa-fw", "fa fa-cloud-upload fa-fw");
		retorno.put("fa fa-upload fa-fw", "fa fa-upload fa-fw");
		retorno.put("fa fa-tty fa-fw", "fa fa-tty fa-fw");
		retorno.put("fa fa-share-alt fa-fw", "fa fa-share-alt fa-fw");
		retorno.put("fa fa-money fa-fw", "fa fa-money fa-fw");
		retorno.put("fa fa-btc fa-fw", "fa fa-btc fa-fw");
		retorno.put("fa fa-archive fa-fw", "fa fa-archive fa-fw");
		retorno.put("fa fa-envelope fa-fw", "fa fa-envelope fa-fw");
		retorno.put("fa fa-bookmark fa-fw", "fa fa-bookmark fa-fw");
		retorno.put("fa fa-tasks fa-fw", "fa fa-tasks fa-fw");
		retorno.put("fa fa-bars fa-fw", "fa fa-bars fa-fw");
		retorno.put("fa fa-cog  fa-fw", "fa fa-cog fa-fw");
		retorno.put("fa fa-cogs fa-fw", "fa fa-cogs fa-fw");
		
		return retorno;
	}
}
