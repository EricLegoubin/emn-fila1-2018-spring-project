package org.emn.fila1.spring.cop.controller;

import org.emn.fila1.spring.cop.model.Course;
import org.emn.fila1.spring.cop.model.CourseCOP;
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

	// TODO It would be better to have a service between the controller and the repository.
	@Autowired
	private CourseRepository courseRepository;


	@GetMapping("/{id}")
	public CourseCOP getCourse(@PathVariable("id") final String id) {
		return courseRepository.findOne(id);
	}


	@GetMapping("")
	public Iterable<CourseCOP> getAllCourses() {
		return courseRepository.findAll();
	}
}