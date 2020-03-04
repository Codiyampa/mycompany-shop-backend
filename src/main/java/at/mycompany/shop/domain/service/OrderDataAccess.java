package at.mycompany.shop.domain.service;

import at.mycompany.shop.domain.model.entity.Order;

import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

public interface OrderDataAccess {
    List<Order> getOrders();
    Order getOrderById(Integer id);
}