package at.mycompany.shop.domain.service;

import at.mycompany.shop.domain.model.entity.Order;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

public interface OrderService {
    Integer createOrder(Order order);
}