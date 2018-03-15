package org.emn.fila1.spring.controller;


import org.emn.fila1.spring.model.Course;
import org.emn.fila1.spring.repository.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class TestController {

    private CourseRepository courseRepository;

    public TestController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/add/{id}")
    public Course add(@PathVariable("id") final String id) {
        courseRepository.save(new Course(id));
        return courseRepository.findById(id);
    }

    @GetMapping("/update/{id}")
    public Course update(@PathVariable("id") final String id) {
        courseRepository.update(new Course(id));
        return courseRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, Course> delete(@PathVariable("id") final String id) {
        courseRepository.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, Course> all() {
        return courseRepository.findAll();
    }
}