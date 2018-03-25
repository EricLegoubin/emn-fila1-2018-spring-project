package com.emn.GEO.simulateur;

import java.util.List;
import java.util.Map;

import com.emn.GEO.domain.Course;
import com.emn.GEO.domain.Passage;
import java.util.Random;

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
            for(int i = 0; i < coursesToSimulate.size(); i++){
                if(i == 2){
                    Course c = coursesToSimulate.get(i);
                    c.addCancelationOnPassage(c.getPassages().get(2).getPoi().getId());
                }
                if(i%3 == 0){
                    Course c = coursesToSimulate.get(i);
                    int time = new Random().nextInt(59) + 1;
                    int poi = new Random().nextInt(c.getPassages().size());
                    c.addPerturbationOnPassage(c.getPassages().get(poi).getPoi().getId(), time);
                }
            }
		this.coursesToSimulate.forEach((course)-> {
                        new Thread(course).start();
		});
	}
        
        public void addCourse(Course c){
            coursesToSimulate.add(c);
        }
	
}
