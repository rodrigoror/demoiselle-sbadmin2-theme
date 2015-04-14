/**
 * 
 */
package org.rlabs.teste02.config;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.SendStatus;
import org.ocpsoft.rewrite.config.ConfigurationProvider;
/*
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.Forward;*/
import org.ocpsoft.rewrite.servlet.config.Path;


/**
 * Add one class, a configuration provider, which implements the primary org.ocpsoft.rewrite.config.ConfigurationProvider interface. In a Servlet environment, you may also extend from the abstract HttpConfigurationProvider class for convenience:
 * @author rodrigo.ramos
 * @see http://www.ocpsoft.org/rewrite/#section-7 - 2. Implement a ConfigurationProvider
 */
@RewriteConfiguration
public class ConfigurationProvider2 extends HttpConfigurationProvider implements ConfigurationProvider<ServletContext>{

	@Override
	public int priority()
	{
		return 10;
	}
	
   @Override
   public boolean handles(Object payload)
   {
      return payload instanceof ServletContext;
   }
	   
	@Override
	public Configuration getConfiguration(final ServletContext context)
	{
		return ConfigurationBuilder.begin()/*
		.addRule()
	         .when(Direction.isInbound().and(Path.matches("/some/{page}/")))
	         .perform(Forward.to("/new-{page}/"))*/
				.addRule()
	               .when(Path.matches("/config-enabled-by-annotation"))
	               .perform(SendStatus.code(299));
	}
}
