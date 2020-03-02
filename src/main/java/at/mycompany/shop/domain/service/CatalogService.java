package at.mycompany.shop.domain.service;

import at.mycompany.shop.domain.model.entity.Order;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

public interface CatalogService {
    Integer createOrder(Order order);
}