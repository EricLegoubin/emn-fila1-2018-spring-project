package com.emn.GEO.simulateur;

import java.util.List;
import java.util.Map;

import com.emn.GEO.domain.Course;
import com.emn.GEO.domain.Passage;

public class Simulateur{
		
	private List<Course> coursesToSimulate;
	
	private Map<Long, List<Passage>> perturbations;
	
	public Simulateur(List<Course> coursesToSimulate) {
		super();
		this.coursesToSimulate = coursesToSimulate;
	}
	
	public Simulateur(List<Course> coursesToSimulate, Map<Long, List<Passage>> perturbations)
	{
		super();
		this.perturbations = perturbations;
		this.coursesToSimulate = coursesToSimulate;
	}
		
	public void startSimulation() {
		this.coursesToSimulate.forEach((course)-> {
			//TODO add perturbation simulation
			course.run();
		});
	}
	
}
