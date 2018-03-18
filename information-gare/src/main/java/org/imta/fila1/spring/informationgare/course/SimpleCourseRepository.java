package org.imta.fila1.spring.informationgare.course;

import java.util.ArrayList;
import java.util.List;

public class SimpleCourseRepository implements CourseRepository {

	private final List<Course> courses = new ArrayList<Course>();

	@Override
	public List<Course> findAll() {
		return new ArrayList<Course>(this.courses);
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
