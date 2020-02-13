package at.mycompany.shop.catalog.core.impl;

import at.mycompany.shop.catalog.core.api.CatalogService;
import at.mycompany.shop.catalog.core.model.jpa.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@ApplicationScoped
public class CatalogServiceImpl implements CatalogService {

    @Inject
    EntityManager em;

    @Override
    public Integer createProduct(Product product) {
        em.persist(product);
        em.flush();
        return product.getId();
    }

    @Override
    public Product updateProduct(Product product) {
        return em.merge(product);
    }
}