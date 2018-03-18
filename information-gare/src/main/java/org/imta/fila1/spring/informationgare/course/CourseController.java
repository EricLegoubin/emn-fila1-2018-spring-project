package org.imta.fila1.spring.informationgare.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CourseController {

    @Autowired
    private CourseServiceStub courseService;

    @RequestMapping("/departs/{gare}")
    public ModelAndView getDeparts(@PathVariable String gare) {
        return getCourse("departs", gare, "coursesView");
    }

    @RequestMapping("/arrivees/{gare}")
    public ModelAndView getArrivees(@PathVariable String gare) {
        return getCourse("arrivees", gare, "coursesView");
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
    public void testAddRetard() {
        courseService.addRetardDepart();
    }

    @RequestMapping(value = "/update")
    public ModelAndView someMethod(@RequestParam("type") String type, @RequestParam("gare") String gare) {
        //System.out.println("/" + type + "/" + gare);

        //return new ModelAndView("coursesView :: resultsList");

        //model.addAttribute("courses",courseService.getDeparts(courseService.getActualCity()));
        //return "redirect:/" + courseService.getActualType() + "/" + courseService.getActualCity();
        //        return "redirect:/departs/cholet";
        return getCourse(type, gare, "coursesView :: resultsList");
        //return "coursesView :: resultsList";
    }
}
