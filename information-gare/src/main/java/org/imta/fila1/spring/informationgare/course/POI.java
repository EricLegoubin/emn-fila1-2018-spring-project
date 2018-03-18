package org.imta.fila1.spring.informationgare.course;

/**
 * Classe des points d'intérêts présents sur un sillon
 * 
 * @author Cédric GARCIA
 *
 */
public class POI {

	private int idPOI;
	private boolean isGare;
	private String nomPOI;

	public POI(int idPOI, boolean isGare, String nomPOI) {

		this.idPOI = idPOI;
		this.isGare = isGare;
		this.nomPOI = nomPOI.toLowerCase();
	}

	public POI() {
	}

	// Getters - Setters
	public int getIdPOI() {

		return idPOI;
	}

	public void setIdPOI(int id) {

		this.idPOI = id;
	}

	public boolean getIsGare() {

		return isGare;
	}

	public void setIsGare(boolean isGare) {

		this.isGare = isGare;
	}

	public String getNomPOI() {

		return nomPOI;
	}

	public void setNomPOI(String nomPOI) {

		this.nomPOI = nomPOI;
	}
}
