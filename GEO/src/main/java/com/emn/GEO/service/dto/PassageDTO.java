package com.emn.GEO.service.dto;

import java.security.Timestamp;


public class PassageDTO {

	private Long POIId;
	
	private Timestamp timestamp;
	    
	private Long CourseId;
	
	
    public PassageDTO() {
    	super();
    }

	public PassageDTO(Long pOIId, Timestamp timestamp, Long courseId) {
		super();
		POIId = pOIId;
		this.timestamp = timestamp;
		CourseId = courseId;
	}

	public Long getPOIId() {
		return POIId;
	}

	public void setPOIId(Long pOIId) {
		POIId = pOIId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


	public Long getCourseId() {
		return CourseId;
	}


	public void setCourseId(Long courseId) {
		CourseId = courseId;
	}

}