package org.emn.fila1.spring.repository;

import java.util.Map;

import org.emn.fila1.spring.model.Course;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepositoryImpl implements CourseRepository{
	
	private RedisTemplate<String, Course> template;
	private HashOperations hashOperations;
	
	public CourseRepositoryImpl(RedisTemplate<String, Course> template) {
		this.template = template;
		this.hashOperations = template.opsForHash();
	}

	@Override
	public void save(Course course) {
		hashOperations.put("COURSE", course.getId(), course);
	}

	@Override
	public Map<String, Course> findAll() {
		return hashOperations.entries("COURSE");
	}

	@Override
	public Course findById(String id) {
		return (Course) hashOperations.get("COURSE", id);
	}

	@Override
	public void update(Course course) {
		save(course);	
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("COURSE", id);
	}
}
