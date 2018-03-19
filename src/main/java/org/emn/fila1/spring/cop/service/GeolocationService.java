package org.emn.fila1.spring.cop.service;


import org.emn.fila1.spring.cop.model.CourseCOP;
import org.emn.fila1.spring.cop.model.Passage;
import org.emn.fila1.spring.cop.model.PassageCOP;
import org.emn.fila1.spring.cop.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeolocationService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private  IngService ingService;

    public void calculatePassage (Passage passage) {

        CourseCOP course = courseRepository.findOne(passage.getIdCourse());

        PassageCOP passageToSend = null;
        boolean found = false;
        long delta = 0;
        int listSize = course.getPassages().size();
        int index = 0;

        for(PassageCOP p: course.getPassages()) {

            if (found) {
                p.getCalculatedDate().setTime(p.getTheoricalDate().getTime() + delta);
            }


            if (passage.getId().equals(p.getId())) {
                delta = passage.getDate().getTime() - p.getTheoricalDate().getTime();

                if (delta > 60000 || delta < -60000) {
                    p.setCalculatedDate(passage.getDate());
                    found = true;
                }
                else break;

            }

            if (index == listSize-1) {
                passageToSend = p;
            }
        }

        courseRepository.save(course);

        if (found) {
            ingService.postCourse(passageToSend);
        }

    }


}