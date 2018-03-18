package org.imta.fila1.spring.informationgare.course;

import java.util.List;

/**
 * Interface Repository des courses
 * 
 * @author Cédric GARCIA
 *
 */
public interface CourseRepository {

	List<Course> findAll();

	void add(Course course);

	int countEntries();

}
