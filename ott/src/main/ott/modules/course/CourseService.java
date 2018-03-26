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

    public List<CourseBo> getCourseDtoStartingBetweenDates(Timestamp debut, Timestamp fin) {
        String queryString = "FROM courses c " +
                "INNER JOIN c.computedPassages p " +
                "WHERE p.timestamp > :debut AND p.timestamp < :fin";
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        return query.getResultList();
    }

    public List<CourseBo> getCourseDtoStartingAfterDate(Timestamp debut) {
        String queryString = "FROM courses c " +
                "INNER JOIN c.computedPassages p " +
                "WHERE p.timestamp > :debut";
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("debut", debut);
        return query.getResultList();
    }

}
