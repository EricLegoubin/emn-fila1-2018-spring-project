package main.ott.modules.point;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Optional;

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

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PointBo> criteriaQuery = criteriaBuilder.createQuery(PointBo.class);
        Root<PointBo> root = criteriaQuery.from(PointBo.class);

        criteriaQuery = criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
        Query<PointBo> query = session.createQuery(criteriaQuery);

        PointBo pointBo;
        try {
            pointBo = query.getSingleResult();
        } catch(NoResultException noResultException) {
            return null;
        }

        return pointBoDtoMapper.map(pointBo);
    }

}
