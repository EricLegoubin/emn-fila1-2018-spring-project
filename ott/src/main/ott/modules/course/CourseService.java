package main.ott.modules.course;

import main.ott.modules.base.Service;
import main.ott.modules.point.PointBo;
import main.ott.modules.point.PointBoDtoMapper;
import main.ott.modules.point.PointDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class CourseService extends Service<CourseBo, CourseDto> {

    @Autowired
    public CourseService(SessionFactory sessionFactory, CourseBoDtoMapper courseBoDtoMapper) {
        super(CourseBo.class, sessionFactory, courseBoDtoMapper);
    }

    public boolean checkCourseId(Long id){
        Optional<CourseDto> courseBo = this.getById(id);
        if(courseBo != null){
            return true;
        }else{
            return false;
        }

    }
}
