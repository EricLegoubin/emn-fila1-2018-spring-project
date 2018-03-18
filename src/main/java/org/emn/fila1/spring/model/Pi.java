package org.emn.fila1.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pi implements Serializable {

	@Id
	String id;
	boolean isGare;
	String nom;
	
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
