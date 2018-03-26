package main.ott.service.externalManagement.Job;

import main.ott.modules.course.CourseDto;
import main.ott.service.internalManagement.Job.PushNewCoursesJob;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServices {

    @Autowired
    private SessionFactory sessionFactory;
    private PushNewCoursesJob pushNewCoursesJob;

    public void addCourse(CourseDto course) {
        Session session = sessionFactory.getCurrentSession();
        pushNewCoursesJob.pushCoursesForNewCourse(course);
        session.save(course);
    }

    public void updateCourse(CourseDto course) {
        Session session = sessionFactory.getCurrentSession();
        pushNewCoursesJob.pushCoursesForUpdatedCourse(course);
        session.save(course);
    }
}
