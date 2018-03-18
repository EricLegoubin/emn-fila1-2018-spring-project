package org.emn.fila1.spring.cop.controller;

import org.emn.fila1.spring.cop.model.Course;
import org.emn.fila1.spring.cop.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @see<a href="http://www.restapitutorial.com/lessons/httpmethods.html">Using
 *        HTTP Methods for RESTful Services</a> for a right use of the HTTP
 *        verbs in a REST context.
 */
@RestController
@RequestMapping("/courses")
public class CourseController {
/*
	// TODO It would be better to have a service between the controller and the repository.
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/{id}")
	public Course getCourse(@PathVariable("id") final String id) {
		return courseRepository.findOne(id);
	}

	@PostMapping("/{id}")
	public Course addCourse(@PathVariable("id") final String id) {
		// TODO Fill the Course object with fields from the Request Body
		return courseRepository.save(new Course(id));
	}

	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable("id") final String id) {
		// TODO Fill the Course object with fields from the Request Body
		return courseRepository.save(new Course(id));
	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable("id") final String id) {
		courseRepository.delete(id);
	}

	@GetMapping("")
	public List<Course> getAllCourses() {
		List<Course> l = new ArrayList<Course>();
		courseRepository.findAll().iterator().forEachRemaining(l::add);
		return l;
	}*/
}