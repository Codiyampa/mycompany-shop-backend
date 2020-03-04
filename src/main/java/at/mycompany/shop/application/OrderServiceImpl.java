package at.mycompany.shop.application;

import at.mycompany.shop.domain.model.entity.ProductOrderAmount;
import at.mycompany.shop.domain.model.repository.OrderRepository;
import at.mycompany.shop.domain.service.OrderService;
import at.mycompany.shop.domain.model.entity.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    OrderRepository orderRepository;

    @Override
    public Integer createOrder(Order order) {
        for (ProductOrderAmount pOrderAmount : order.getProductOrderAmounts()) {
            pOrderAmount.setOrder(order);
        }
        return orderRepository.persist(order).getId();
    }
}