package org.emn.fila1.spring.cop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.sql.Timestamp;


public class Passage implements Serializable {

	private static final long serialVersionUID = -6689683732185024631L;

	@Id
	String id;
	Pi pi;
	String idCourse;
	Timestamp date;

	public Passage() {
		super();
	}

	public Passage(String id, Pi pi, String idCourse, Timestamp date) {
		this.id = id;
		this.pi = pi;
		this.idCourse = idCourse;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Pi getPi() {
		return pi;
	}

	public void setPi(Pi pi) {
		this.pi = pi;
	}

	public String getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}
