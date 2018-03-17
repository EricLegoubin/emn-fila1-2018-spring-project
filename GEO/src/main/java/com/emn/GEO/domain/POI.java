package com.emn.GEO.domain;

public class POI {

	private Long id;
	
	private boolean isGare;
	
	private String nom;

	public POI(Long id, boolean isGare, String nom) {
		super();
		this.id = id;
		this.isGare = isGare;
		this.nom = nom;
	}
	
	public Long getId() {
		return this.id;
	}
}
