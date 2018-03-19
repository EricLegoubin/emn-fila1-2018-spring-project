package main.ott.service.internalManagement.externalManagement;

import main.ott.modules.course.CourseDto;
import main.ott.service.internalManagement.Job.PushNewCoursesJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private PushNewCoursesJob newCoursesJob;

    public List<CourseDto> getCourses() {
        //todo cll DB
        return null;
    }

    public CourseDto getCourse(String id) {
        //todo call DB
        return null;
    }

    public void addCourse(String id, CourseDto course) {
        //todo call DB
        newCoursesJob.pushCourses(course);
    }

    public void updateCourse(String id, CourseDto course) {
        //todo call DB
    }

    public void deleteCourse(String id) {
        //todo call DB
    }
}
