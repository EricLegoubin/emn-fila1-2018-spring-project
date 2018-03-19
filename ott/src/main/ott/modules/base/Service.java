package main.ott.modules.base;

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
import java.util.Optional;

@Transactional
public abstract class Service<T, E> {

    private Mapper<T, E> mapper;
    private Class<T> boClass;
    private SessionFactory sessionFactory;

    protected Service(Class<T> boClass, SessionFactory sessionFactory, Mapper<T, E> mapper) {
        this.boClass = boClass;
        this.sessionFactory = sessionFactory;
        this.mapper = mapper;
    }

    protected Optional<E> getSingleResult(CriteriaQuery<T> criteriaQuery) {
        Query<T> query = sessionFactory.getCurrentSession().createQuery(criteriaQuery);
        T returnedBo;
        try {
            returnedBo = query.getSingleResult();
        } catch(NoResultException noResultException) {
            return Optional.empty();
        }
        E returnedValue = mapper.bo2Dto(returnedBo);
        return Optional.of(returnedValue);
    }

    protected String getTableName() {
        MetamodelImplementor metaModel = (MetamodelImplementor) sessionFactory.getMetamodel();
        AbstractEntityPersister persister = (AbstractEntityPersister) metaModel.entityPersister(boClass);
        return persister.getTableName();
    }

    public Optional<E> getById(Long id, String idColumn) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(boClass);
        Root<T> root = criteriaQuery.from(boClass);

        criteriaQuery = criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(idColumn), id));
        return getSingleResult(criteriaQuery);
    }

    public Optional<E> getById(Long id) {
        return getById(id, "id");
    }

    public void Create(E dto) {
        T bo = mapper.dto2Bo(dto);
        sessionFactory.getCurrentSession().save(bo);
    }

    public int DeleteAll() {
        String queryString = String.format("DELETE FROM %s", getTableName());
        Query typedQuery = sessionFactory.getCurrentSession().createQuery(queryString);
        return typedQuery.executeUpdate();
    }

}
