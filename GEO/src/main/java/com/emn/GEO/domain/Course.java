package com.emn.GEO.domain;

import java.util.List;

public class Course {

	private Long id;
	
	private String idTrain;
	
	private List<Sillon> sillons;
	
	private List<Passage> passages;

	private List<Passage> passagesTheoriques;
	
	
	public Course(Long id, String idTrain, List<Sillon> sillons, List<Passage> passages, List<Passage> passagesTheoriques) {
		super();
		this.id = id;
		this.idTrain = idTrain;
		this.sillons = sillons;
		this.passages = passages;
		this.passagesTheoriques = passagesTheoriques;
	}
	
	
}
