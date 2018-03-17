package com.emn.GEO.service.dto;

import java.util.List;

public class SillonDTO {

	private Long id;
	
	private List<Long> poiIds;

	public SillonDTO(Long id, List<Long> poiIds) {
		super();
		this.id = id;
		this.poiIds = poiIds;
	}
	
}
