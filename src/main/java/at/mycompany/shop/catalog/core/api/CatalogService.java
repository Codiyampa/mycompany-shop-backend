package at.mycompany.shop.catalog.core.api;

import at.mycompany.shop.catalog.core.model.jpa.Order;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

public interface CatalogService {
    Integer createOrder(Order order);
}