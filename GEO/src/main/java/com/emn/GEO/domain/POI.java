package com.emn.GEO.domain;

public class POI {

	private Long id;
	
	private boolean gare;
	
	private String nom;

    public POI() {
    }

    public boolean isGare() {
        return gare;
    }

    public void setGare(boolean gare) {
        this.gare = gare;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

        
        
	public POI(Long id, boolean gare, String nom) {
		super();
		this.id = id;
		this.gare = gare;
		this.nom = nom;
	}
	
	public Long getId() {
		return this.id;
	}
}
