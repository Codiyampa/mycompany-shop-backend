package at.mycompany.shop.architecture.repository;

import at.mycompany.shop.domain.model.repository.AbstractRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

public abstract class AbstractRepositoryBean<T, ID extends Serializable> implements AbstractRepository<T, ID> {

    @Inject
    protected EntityManager em;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractRepositoryBean() {
        ParameterizedType thisClass = (ParameterizedType)this.getClass().getGenericSuperclass();
        entityClass = (Class<T>) thisClass.getActualTypeArguments()[0];
    }

    @Override
    public T persist(T entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

    @Override
    public T merge(T entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public T findById(ID id) {
        return em.find(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery(
                String.format("select entity from %s entity", getEntityClass().getName()), getEntityClass())
                .getResultList();
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public String getEntityTableName() {
        Table t = getEntityClass().getAnnotation(Table.class);
        return (t == null) ? getEntityClass().getName().toLowerCase() : t.name();
    }
}