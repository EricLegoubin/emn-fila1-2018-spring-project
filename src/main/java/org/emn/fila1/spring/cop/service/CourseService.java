package org.emn.fila1.spring.cop.service;

import org.emn.fila1.spring.cop.model.Course;
import org.emn.fila1.spring.cop.model.CourseCOP;
import org.emn.fila1.spring.cop.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void addCourse(Course course) {
        courseRepository.save(new CourseCOP(course));
    }

    public void addCourses(List<Course> courses) {
        for (Course c: courses) {
            courseRepository.save(new CourseCOP(c));
        }

    }

}
