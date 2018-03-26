package main.ott.service.externalManagement.Job;

import main.ott.modules.course.CourseDto;
import main.ott.modules.course.CourseService;
import main.ott.modules.point.PointService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    private CourseServices courseServices;
    private CourseService courseService;

    // POST /addCourses
    @RequestMapping(method= RequestMethod.POST, path="/addcourses")
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

    //Get greetings from server
    @RequestMapping(method= RequestMethod.GET, path="/greetings")
    public String getGreetings(){
        return "Greetings from OTT";
    }

    private boolean exists(Long id) {
        if(courseService.getById(id) != null){
            return false;
        }else{
            return true;
        }
    }

}
