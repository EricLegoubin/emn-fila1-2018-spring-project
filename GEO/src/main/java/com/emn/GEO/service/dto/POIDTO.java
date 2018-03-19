package com.emn.GEO.service.dto;

public class POIDTO {

    private Long id;

    private boolean isGare;
    
    private String nom;
    
    public POIDTO() {
    	super();
    }

    public POIDTO(Long id, String nom) {
        super();
        this.id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String toString() {
    	return nom+"("+id+")";
    }

	public boolean isGare() {
		return isGare;
	}

	public void setGare(boolean isGare) {
		this.isGare = isGare;
	}
    

}