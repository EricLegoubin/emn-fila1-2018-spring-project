package com.emn.GEO.domain;

import java.util.Set;

public class Sillon {

	private Long id;
	
	private Set<POI> pois;

	public Sillon(Long id, Set<POI> pois) {
		super();
		this.id = id;
		this.pois = pois;
	}
	
}
