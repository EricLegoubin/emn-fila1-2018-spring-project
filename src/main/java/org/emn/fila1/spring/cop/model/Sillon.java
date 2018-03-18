package org.emn.fila1.spring.cop.model;

import java.io.Serializable;
import java.util.List;

public class Sillon implements Serializable{

	String id;
	List<Pi> pis;
	
	public Sillon(String id, List<Pi> pis)
	{
		this.id = id;
		this.pis = pis;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Pi> getPis() {
		return pis;
	}

	public void setPis(List<Pi> pis) {
		this.pis = pis;
	}
}
