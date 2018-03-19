package main.ott.service.externalManagement.Job;

import main.ott.modules.course.CourseDto;
import main.ott.modules.course.CourseService;
import main.ott.modules.point.PointService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CourseController {

    @Autowired
    private CourseServices courseServices;
    private CourseService courseService;

    // POST /courses/{id}
    @RequestMapping(method= RequestMethod.POST, path="/addCourses")
    public void updateCourse(@RequestBody CourseDto[] courses) {

        for(int i=0; i < courses.length ;i++){
            Long id = courses[i].getId();
            if(this.exists(id)){
                courseServices.updateCourse(courses[i]);
            }else{
                courseServices.addCourse(courses[i]);
            }
        }
    }

    private boolean exists(Long id) {
        return courseService.checkCourseId(id);
    }

}
