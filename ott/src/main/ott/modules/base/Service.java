package main.ott.modules.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class Service<T> {

    protected Class<T> boClass;
    protected SessionFactory sessionFactory;

    protected Service(Class<T> boClass, SessionFactory sessionFactory) {
        this.boClass = boClass;
        this.sessionFactory = sessionFactory;
    }

    protected Optional getSingleResult(CriteriaQuery<T> criteriaQuery) {
        Query query = sessionFactory.getCurrentSession().createQuery(criteriaQuery);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }

    public Optional getById(Long id, String idColumn) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(boClass);

        Root<T> root = criteriaQuery.from(boClass);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(idColumn), id));

        return getSingleResult(criteriaQuery);
    }

    public Optional getById(Long id) {
        return getById(id, "id");
    }

    public void create(T bo) {
        Session session = sessionFactory.getCurrentSession();
        session.save(bo);
    }

    public List<T> getAll() {
        Session session = sessionFactory.getCurrentSession();

        CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder().createQuery(boClass);
        Root<T> root = criteriaQuery.from(boClass);
        criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List instances = getAll();
        for (Object instance : instances) {
            session.delete(instance);
        }

        session.getTransaction().commit();
    }

}
