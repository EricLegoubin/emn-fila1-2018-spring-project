package main.ott.modules.point;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class PointService {

    private SessionFactory sessionFactory;
    private PointBoDtoMapper pointBoDtoMapper;

    @Autowired
    public PointService(SessionFactory sessionFactory, PointBoDtoMapper pointBoDtoMapper) {
        this.sessionFactory = sessionFactory;
        this.pointBoDtoMapper = pointBoDtoMapper;
    }

    public PointDto getPoint(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

}
