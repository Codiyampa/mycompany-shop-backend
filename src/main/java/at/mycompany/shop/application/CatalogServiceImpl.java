package at.mycompany.shop.application;

import at.mycompany.shop.domain.service.CatalogService;
import at.mycompany.shop.domain.model.entity.Order;
import at.mycompany.shop.domain.model.entity.ProductOrderAmount;

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