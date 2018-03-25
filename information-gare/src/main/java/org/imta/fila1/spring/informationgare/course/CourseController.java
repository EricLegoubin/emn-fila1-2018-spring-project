package org.imta.fila1.spring.informationgare.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseServiceStub courseService;

    @RequestMapping("/departs/{gare}")
    public ModelAndView getDeparts(@PathVariable String gare, @RequestParam Optional<String> salt) {
        if(salt.isPresent()){
            return getCourse("departs", gare, "departureView");
        } else {
            return getCourse("departs", gare, "coursesView");
        }
    }

    @RequestMapping("/arrivees/{gare}")
    public ModelAndView getArrivees(@PathVariable String gare, @RequestParam Optional<String> salt) {
        if(salt.isPresent()){
            return getCourse("arrivees", gare, "departureView");
        } else {
            return getCourse("arrivees", gare, "coursesView");
        }
    }

    public ModelAndView getCourse(String aType, String aGare, String template) {
        ModelAndView vView = new ModelAndView("errorView");
        if (aGare != null) {
            vView = new ModelAndView(template);
            if (aType.equals("departs")) {
                vView.addObject("courses", courseService.getDeparts(aGare));
            } else {
                vView.addObject("courses", courseService.getArrivees(aGare));
            }
            vView.addObject("gare", aGare);
            vView.addObject("type", aType);
        }
        return vView;
    }

    @RequestMapping(path = "testAdd")
    public void testAdd() {
        courseService.duplicate();
    }

    @RequestMapping(path = "testAddRetard")
    public void testAddRetard(@RequestParam("type") String type) {
        courseService.addRetard(type);
    }

    @RequestMapping(value = "/update")
    public ModelAndView someMethod(@RequestParam("type") String type, @RequestParam("gare") String gare, @RequestParam String style) {
        if(style.equals("old")){
            return getCourse(type, gare, "departureView :: list");
        } else {
            return getCourse(type, gare, "coursesView :: resultsList");
        }
    }
}
