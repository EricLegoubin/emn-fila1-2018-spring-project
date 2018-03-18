package org.imta.fila1.spring.informationgare.modele.catalogue;

import java.util.ArrayList;

import org.imta.fila1.spring.informationgare.course.POI;
import org.imta.fila1.spring.informationgare.course.Passage;
import org.imta.fila1.spring.informationgare.course.Sillon;

/**
 * 
 * @category Nous avons besoin de cette classe car c'est cet objet qui sera
 *           envoyé par l'équipe catalogue Nous allons donc l'utiliser pour
 *           désérialiser le JSON puis créer l'objet course qui nous intéresse.
 *
 */
public class CourseCatalogue {

	private int idCourse;
	private int numTrain;
	private ArrayList<Sillon> listSillons;
	private ArrayList<Passage> listPassages;

	public CourseCatalogue(int idCourse, int numTrain, ArrayList<Sillon> listSillons, ArrayList<Passage> listPassages) {

		this.idCourse = idCourse;
		this.numTrain = numTrain;
		this.listSillons = listSillons;
		this.listPassages = listPassages;
	}

	public CourseCatalogue() {
	}

	// Getters - Setters
	public int getIdCourse() {

		return idCourse;
	}

	public void setIdCourse(int idCourse) {

		this.idCourse = idCourse;
	}

	public int getNumTrain() {

		return numTrain;
	}

	public void setNumTrain(int numTrain) {

		this.numTrain = numTrain;
	}

	public ArrayList<Sillon> getListSillons() {

		return listSillons;
	}

	public void setListSillons(ArrayList<Sillon> listSillons) {

		this.listSillons = listSillons;
	}

	public ArrayList<Passage> getListPassages() {

		return listPassages;
	}

	public void setListPassages(ArrayList<Passage> listPassages) {

		this.listPassages = listPassages;
	}

	public boolean isGareDepart(String aGare) {
		POI vPoi = getListPassages().get(0).getPoiPassage();
		return vPoi.getNomPOI().equals(aGare);
	}

	public boolean isGareArrivee(String aGare) {
		POI vPoi = getListPassages().get(getListPassages().size()).getPoiPassage();
		return vPoi.getNomPOI().equals(aGare);

	}

}