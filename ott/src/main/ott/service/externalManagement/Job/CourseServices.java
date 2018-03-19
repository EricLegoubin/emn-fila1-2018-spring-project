package main.ott.service.externalManagement.Job;

import main.ott.modules.course.CourseDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseServices {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCourse(CourseDto course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    public void updateCourse(CourseDto course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }
}
