package at.mycompany.shop.domain.model.repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

public interface AbstractRepository<T, ID extends Serializable> {
    T persist(T entity);
    T merge(T entity);
    void delete(T entity);
    T findById(ID id);
    List<T> findAll();
}