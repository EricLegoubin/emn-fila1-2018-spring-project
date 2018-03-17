package com.emn.GEO.domain;

import java.security.Timestamp;

import com.emn.GEO.kafka.Sender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Passage implements Runnable {

	private Course course;

	private POI poi;

	private Timestamp time;

	public Passage(Course course, POI poi, Timestamp time) {
		super();
		this.course = course;
		this.poi = poi;
		this.time = time;
	}

	public void run() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// TODO convert to DTO
			Sender.sender.send("passage", mapper.writeValueAsString(this));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public Timestamp getTime() {
		return time;
	}

	public POI getPoi() {
		return poi;
	}

	
}
