package org.emn.fila1.spring.repository;

import java.util.Map;

import org.emn.fila1.spring.model.Course;

public interface CourseRepository {
	
	void save(Course course);
	
	Map<String, Course> findAll();
	
	Course findById(String id);
	
	void update(Course course);
	
	void delete(String id);
}
