package at.mycompany.shop.architecture.repository;

import at.mycompany.shop.domain.model.repository.AbstractRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

public abstract class AbstractRepositoryBean<T, ID extends Serializable> implements AbstractRepository<T, ID> {

    @Inject
    private EntityManager em;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractRepositoryBean() {
        ParameterizedType thisClass = (ParameterizedType)this.getClass().getGenericSuperclass();
        entityClass = (Class<T>) thisClass.getActualTypeArguments()[0];
    }

    /* default methods */
    @Override
    public T persist(T entity) {
        getEntityManager().persist(entity);
        getEntityManager().flush();
        return entity;
    }

    @Override
    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public T findById(ID id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        return getEntityManager().createQuery(
                String.format("select entity from %s entity", getEntityClass().getName()), getEntityClass())
                .getResultList();
    }

    /* helper methods */
    protected Class<T> getEntityClass() {
        return entityClass;
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    protected String getEntityTableName() {
        Table t = getEntityClass().getAnnotation(Table.class);
        return (t == null) ? getEntityClass().getName().toLowerCase() : t.name();
    }

    protected Session getHibernateSession() {
        return getEntityManager().unwrap(Session.class);
    }

    public T getEntityProxy(Serializable id) {
        return getHibernateSession().load(getEntityClass(), id);
    }

    protected CriteriaBuilder getCriteriaBuilder() {
        return getHibernateSession().getCriteriaBuilder();
    }

    protected CriteriaQuery<T> getCriteriaQuery(CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.createQuery(getEntityClass());
    }

    protected CriteriaQuery<T> getCriteriaQuery(CriteriaBuilder criteriaBuilder, Class<T> clazz) {
        return criteriaBuilder.createQuery(clazz);
    }

    protected Root<T> getRoot(CriteriaQuery<?> criteriaQuery, Class<T> clazz) {
        return criteriaQuery.from(clazz);
    }

    protected Root<T> getRoot(CriteriaQuery<T> criteriaQuery) {
        return criteriaQuery.from(getEntityClass());
    }

    protected T getSingleResult(CriteriaQuery<T> criteriaQuery) {
        Query<T> query = getHibernateSession().createQuery(criteriaQuery);
        try {
            return query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }

    protected List<T> getResultList(CriteriaQuery<T> criteriaQuery) {
        TypedQuery<T> query = getHibernateSession().createQuery(criteriaQuery);
        try {
            return query.getResultList();
        } catch (NoResultException noResultException) {
            return null;
        }
    }
}