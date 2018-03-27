package org.imta.fila1.spring.informationgare.course;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleCourseRepository implements CourseRepository {

	private final List<Course> courses = new ArrayList<>();

	@Override
	public Set<Course> findAll() {
		return new HashSet<Course>(this.courses);
	}

	@Override
	public void add(final Course course) {
		this.courses.add(course);
	}

	@Override
	public int countEntries() {
		return this.courses.size();
	}
}
