/**
 * 
 */
package org.rlabs.teste02.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author rodrigo.ramos
 *
 */
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="comp_id"
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name="comp_id", nullable=false)
	private Long comp_id;
	

}
