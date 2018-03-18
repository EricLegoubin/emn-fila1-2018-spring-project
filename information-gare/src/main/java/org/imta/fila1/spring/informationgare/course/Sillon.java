package org.imta.fila1.spring.informationgare.course;

import java.util.ArrayList;

/**
 * Classe de définition de sillons
 * 
 * @author Cédric GARCIA
 *
 */
public class Sillon {

	private int idSillon;
	private ArrayList<POI> listPOIs;

	public Sillon(int idSillon, ArrayList<POI> listPOI) {

		this.idSillon = idSillon;
		this.listPOIs = listPOI;
	}

	public Sillon() {
	}

	// Getters - Setters
	public int getIdSillon() {

		return idSillon;
	}

	public void setIdSillon(int idSillon) {

		this.idSillon = idSillon;
	}

	public ArrayList<POI> getListPOI() {

		return listPOIs;
	}

	public void setListPOI(ArrayList<POI> listPOI) {

		this.listPOIs = listPOI;
	}
}
