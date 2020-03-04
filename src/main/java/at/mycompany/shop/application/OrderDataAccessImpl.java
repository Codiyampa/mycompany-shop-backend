package at.mycompany.shop.application;

import at.mycompany.shop.domain.model.entity.Order;
import at.mycompany.shop.domain.model.repository.OrderRepository;
import at.mycompany.shop.domain.service.OrderDataAccess;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

@ApplicationScoped
public class OrderDataAccessImpl implements OrderDataAccess {

    @Inject
    OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id);
    }
}