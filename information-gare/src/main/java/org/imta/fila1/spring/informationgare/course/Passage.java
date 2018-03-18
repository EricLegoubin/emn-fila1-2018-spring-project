package org.imta.fila1.spring.informationgare.course;

import java.sql.Timestamp;

/**
 * Classe des points des points de passage des trains sur un sillon
 * 
 * @author Cédric GARCIA
 *
 */
public class Passage {

	private Timestamp timestamp;
	private int idCourse;
	private POI poiPassage;

	public Passage(Timestamp timestamp, int idCourse, POI poiPassage) {

		this.timestamp = timestamp;
		this.idCourse = idCourse;
		this.poiPassage = poiPassage;
	}

	public Passage() {
	}

	// Getters - Setters
	public Timestamp getTimestamp() {

		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {

		this.timestamp = timestamp;
	}

	public int getIdCourse() {

		return idCourse;
	}

	public void setIdCourse(int idCourse) {

		this.idCourse = idCourse;
	}

	public POI getPoiPassage() {

		return poiPassage;
	}

	public void setPoiPassage(POI poiPassage) {

		this.poiPassage = poiPassage;
	}
}
