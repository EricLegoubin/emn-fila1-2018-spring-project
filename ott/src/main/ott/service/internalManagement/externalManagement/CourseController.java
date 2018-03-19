//package main.ott.service.internalManagement.externalManagement;
//
//import main.ott.modules.course.CourseDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class CourseController {
//
//    @Autowired
//    private  courseService;
//
//
//
//    @RequestMapping("/courses")
//    public List<CourseDto> getCourses() {
//        return courseService.getCourses();
//    }
//
//    // GET /courses/{id}
//    @RequestMapping("/courses/{id}")
//    public CourseDto getCourse(@PathVariable String id) {
//        return courseService.getCourse(id);
//    }
//
//    // PUT /courses/{id}
//    @RequestMapping(method=RequestMethod.PUT, path="/courses/{id}")
//    public void addCourse(@PathVariable String id, @RequestBody CourseDto course) {
//        courseService.addCourse(id, course);
//    }
//
//    // POST /courses/{id}
//    @RequestMapping(method= RequestMethod.POST, path="/courses/{id}")
//    public void updateCourse(@PathVariable String id, @RequestBody CourseDto course) {
//        courseService.updateCourse(id, course);
//    }
//
//
//    // DELETE /courses/{id}
//    @RequestMapping(method=RequestMethod.DELETE, path="/courses/{id}")
//    public void updateCourse(@PathVariable String id) {
//        courseService.deleteCourse(id);
//    }
//
//}
