package com.emn.GEO.service.dto;

import java.util.List;

public class CourseDTO {

	private Long id;
	
	private String idTrain;
	
	private List<Long> sillonIds;
	
	private List<Long> passageIds;

	private List<Long> passageTheoriqueIds;

	
	public CourseDTO(Long id, String idTrain, List<Long> sillonIds, List<Long> passageIds, List<Long> passageTheoriqueIds) {
		super();
		this.id = id;
		this.idTrain = idTrain;
		this.sillonIds = sillonIds;
		this.passageIds = passageIds;
		this.passageTheoriqueIds = passageTheoriqueIds;
	}
	
}
