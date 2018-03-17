package com.emn.GEO.service.dto;

public class POIDTO {

	private Long id;
	
	private boolean isGare;
	
	private String nom;

	public POIDTO(Long id, boolean isGare, String nom) {
		super();
		this.id = id;
		this.isGare = isGare;
		this.nom = nom;
	}
	
}
