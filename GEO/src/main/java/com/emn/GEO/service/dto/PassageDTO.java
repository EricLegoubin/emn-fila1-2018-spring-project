package com.emn.GEO.service.dto;

import java.security.Timestamp;

public class PassageDTO {

	private Long courseId;
	
	private Long poiId;
	
	private Timestamp time;

	public PassageDTO(Long courseId, Long poiId, Timestamp time) {
		super();
		this.courseId = courseId;
		this.poiId = poiId;
		this.time = time;
	}
	
	
}
