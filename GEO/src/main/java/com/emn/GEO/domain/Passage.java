package com.emn.GEO.domain;

import java.security.Timestamp;

public class Passage {

	private Course course;
	
	private POI poi;
	
	private Timestamp time;

	public Passage(Course course, POI poi, Timestamp time) {
		super();
		this.course = course;
		this.poi = poi;
		this.time = time;
	}
	
}
