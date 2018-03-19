package org.emn.fila1.spring.cop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


public class Passage implements Serializable {

	private static final long serialVersionUID = -6689683732185024631L;

	@Id
	String id;
	POI poi;
	String idCourse;
	Date date;

	public Passage() {
		super();
	}

	public Passage(String id, POI poi, String idCourse, Timestamp date) {
		this.id = id;
		this.poi = poi;
		this.idCourse = idCourse;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public POI getPoi() {
		return poi;
	}

	public void setPoi(POI poi) {
		this.poi = poi;
	}

	public String getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
