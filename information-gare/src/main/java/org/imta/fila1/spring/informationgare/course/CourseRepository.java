package org.imta.fila1.spring.informationgare.course;

import java.util.Set;

/**
 * Interface Repository des courses
 * 
 * @author Cédric GARCIA
 *
 */
public interface CourseRepository {

	Set<Course> findAll();

	void add(Course course);

	int countEntries();

}
