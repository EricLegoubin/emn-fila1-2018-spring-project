package main.ott.modules.base;

import main.ott.modules.course.CourseBo;
import main.ott.modules.course.CourseDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class Service<T> {

    private Class<T> boClass;
    private SessionFactory sessionFactory;

    protected Service(Class<T> boClass, SessionFactory sessionFactory) {
        this.boClass = boClass;
        this.sessionFactory = sessionFactory;
    }

    protected Optional<T> getSingleResult(CriteriaQuery<T> criteriaQuery) {
        Query<T> query = sessionFactory.getCurrentSession().createQuery(criteriaQuery);
        try {
            return Optional.of(query.getSingleResult());
        } catch(NoResultException noResultException) {
            return Optional.empty();
        }
    }

    protected String getTableName() {
        MetamodelImplementor metaModel = (MetamodelImplementor) sessionFactory.getMetamodel();
        AbstractEntityPersister persister = (AbstractEntityPersister) metaModel.entityPersister(boClass);
        return persister.getTableName();
    }

    public Optional<T> getById(Long id, String idColumn) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(boClass);
        Root<T> root = criteriaQuery.from(boClass);

        criteriaQuery = criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(idColumn), id));
        return getSingleResult(criteriaQuery);
    }

    public Optional<T> getById(Long id) {
        return getById(id, "id");
    }

    public void create(T bo) {
        Session session = sessionFactory.getCurrentSession();
        session.save(bo);
    }

    public int deleteAll() {
        String queryString = String.format("DELETE FROM %s", getTableName());
        Query typedQuery = sessionFactory.getCurrentSession().createQuery(queryString);
        return typedQuery.executeUpdate();
    }

    public List<CourseBo> getCourseDtoStartingAfterDate(Timestamp timestamp){
        String queryString = String.format("SELECT * FROM courses c WHERE c.id IN (SELECT cp.courses_id FROM courses_passages cp WHERE cp.computedPassages_id IN (SELECT p.id FROM passages p WHERE p.dateTime >= %s )" , timestamp.toString());
        Query typedQuery = sessionFactory.getCurrentSession().createQuery(queryString);
        return typedQuery.getResultList();
    }

}
