package at.mycompany.shop.catalog.core.impl;

import at.mycompany.shop.catalog.core.api.CatalogDataAccess;
import at.mycompany.shop.catalog.core.model.jpa.Product;

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
        Query query = em.createQuery("SELECT p FROM Product p", Product.class);
        return (List<Product>) query.getResultList();
    }

    @Override
    public Product getProductById(Integer id) {
        return em.find(Product.class, id);
    }
}