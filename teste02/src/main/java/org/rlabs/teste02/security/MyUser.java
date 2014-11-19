package org.rlabs.teste02.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.gov.frameworkdemoiselle.security.User;

/**
 * @author  rodrigo.ramos
 */
public class MyUser implements User, Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="id"
	 */
	private String id;
	
	private Map<Object, Object> attributes = new HashMap<Object, Object>();

	
	@Override
	public Object getAttribute(Object key) {
		return attributes.get(key);
	}
	

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	@Override
	public String getId() {
		return this.id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "MyUser [id=" + id + ", attributes=" + attributes + "]";
	}
	

	@Override
	public void setAttribute(Object key, Object value) {
		attributes.put(key, value);	
	}
	
}
