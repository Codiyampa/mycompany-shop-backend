package at.mycompany.shop.catalog.core.impl;

import at.mycompany.shop.catalog.core.api.CatalogService;
import at.mycompany.shop.catalog.core.model.jpa.Order;
import at.mycompany.shop.catalog.core.model.jpa.ProductOrderAmount;

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
    public Integer createOrder(Order order) {
        for (ProductOrderAmount pOrderAmount : order.getProductOrderAmounts()) {
            pOrderAmount.setOrder(order);
        }
        em.persist(order);
        em.flush();
        return order.getId();
    }
}