package main.ott.modules.course;

import main.ott.modules.base.Service;
import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointBoDtoMapper;
import main.ott.modules.point.PointDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Component
public class CourseService extends Service<CourseBo> {

    @Autowired
    public CourseService(SessionFactory sessionFactory) {
        super(CourseBo.class, sessionFactory);
    }

}
