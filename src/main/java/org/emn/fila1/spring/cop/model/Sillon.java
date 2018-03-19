package org.emn.fila1.spring.cop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;


public class Sillon implements Serializable{


	private static final long serialVersionUID = -6821835822588154831L;

	@Id
	String id;
	List<POI> pis;

	public Sillon() {
		super();
	}
	
	public Sillon(String id, List<POI> pis)
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

	public List<POI> getPis() {
		return pis;
	}

	public void setPis(List<POI> pis) {
		this.pis = pis;
	}
}
