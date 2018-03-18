package org.emn.fila1.spring.cop.controller;

import org.emn.fila1.spring.cop.model.Course;
import org.emn.fila1.spring.cop.repository.CourseRepository;
import org.emn.fila1.spring.cop.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.JSONObject;

import java.util.List;

@RestController
public class OdtController {

    @Autowired
    private CourseService courseService;

    @PutMapping("/odt/course")
    public void addCourse (@RequestBody Course course)
    {
        courseService.addCourse(course);
    }

    @PutMapping("/odt/courses")
    public void addCourses(@RequestBody List<Course> courses)
    {
        courseService.addCourses(courses);
    }



}
