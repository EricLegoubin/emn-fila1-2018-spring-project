package main.ott.modules.course;

import main.ott.modules.base.Service;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class CourseService extends Service<CourseBo> {

    @Autowired
    public CourseService(SessionFactory sessionFactory) {
        super(CourseBo.class, sessionFactory);
    }

    public List getCourseDtoStartingAfterDate(Timestamp timestamp) {
        String queryString = String.format("SELECT * FROM courses c WHERE c.id IN " +
                "(SELECT cp.courses_id FROM courses_passages cp WHERE cp.computedPassages_id IN " +
                "(SELECT p.id FROM passages p WHERE p.dateTime >= %s )",
                timestamp.toString());
        Query typedQuery = sessionFactory.getCurrentSession().createQuery(queryString);
        return typedQuery.getResultList();
    }

    public List getCourseDtoStartingBetweenDates(Timestamp debut, Timestamp fin) {
        String queryString = String.format("SELECT * FROM courses c WHERE c.id IN " +
                "(SELECT cp.courses_id FROM courses_passages cp WHERE cp.computedPassages_id IN " +
                "(SELECT p.id FROM passages p WHERE p.dateTime > %s  AND p.dateTime >= %s)",
                debut.toString(), fin.toString());
        Query typedQuery = sessionFactory.getCurrentSession().createQuery(queryString);
        return typedQuery.getResultList();
    }

}
