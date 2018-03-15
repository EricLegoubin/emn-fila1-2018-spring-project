package org.emn.fila1.spring.model;

import java.io.Serializable;

public class Course implements Serializable {
	String id;
	
	public Course(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	/* TODO - MODEL */
}
