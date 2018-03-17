package com.emn.GEO.simulateur;

import java.util.List;
import java.util.Map;

import com.emn.GEO.domain.Course;
import com.emn.GEO.domain.Passage;

public class Simulateur{
		
	private List<Course> coursesToSimulate;
	
	private Map<Course, List<Passage>> perturbations;
	
	public Simulateur(List<Course> coursesToSimulate) {
		super();
		this.coursesToSimulate = coursesToSimulate;
	}
	
	public Simulateur(List<Course> coursesToSimulate, Map<Course, List<Passage>> perturbations)
	{
		super();
		this.perturbations = perturbations;
		this.coursesToSimulate = coursesToSimulate;
	}
	
}
