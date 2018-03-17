package com.emn.GEO.domain;

import java.util.List;

public class Sillon {

	private Long id;
	
	private List<POI> pois;

	public Sillon(Long id, List<POI> pois) {
		super();
		this.id = id;
		this.pois = pois;
	}
	
}
