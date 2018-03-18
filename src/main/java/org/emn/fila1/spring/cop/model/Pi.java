package org.emn.fila1.spring.cop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


public class Pi implements Serializable {

	private static final long serialVersionUID = 2451555111829706003L;

	@Id
	String id;
	boolean isGare;
	String nom;

	public Pi() {
		super();
	}
	
	public Pi(String id, boolean isGare, String nom)
	{
		this.id = id;
		this.isGare = isGare;
		this.nom = nom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isGare() {
		return isGare;
	}

	public void setGare(boolean isGare) {
		this.isGare = isGare;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
