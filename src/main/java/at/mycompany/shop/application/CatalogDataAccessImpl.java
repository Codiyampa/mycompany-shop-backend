package at.mycompany.shop.application;

import at.mycompany.shop.domain.service.CatalogDataAccess;
import at.mycompany.shop.domain.model.entity.Order;
import at.mycompany.shop.domain.model.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@ApplicationScoped
public class CatalogDataAccessImpl implements CatalogDataAccess {
    @Inject
    EntityManager em;

    @Override
    public List<Product> getProducts() {
        Query query = em.createQuery("SELECT p FROM product p", Product.class);
        return (List<Product>) query.getResultList();
    }

    @Override
    public Product getProductById(Integer id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Order> getOrders() {
        Query query = em.createQuery("SELECT o FROM order o", Order.class);
        return (List<Order>) query.getResultList();
    }

    @Override
    public Order getOrderById(Integer id) {
        return em.find(Order.class, id);
    }
}