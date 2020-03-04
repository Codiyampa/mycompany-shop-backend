package at.mycompany.shop.domain.model.repository;

import at.mycompany.shop.domain.model.entity.Order;

import java.time.Instant;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

public interface OrderRepository extends AbstractRepository<Order, Integer> {
    List<Order> findByDate(Instant beginDate, Instant endDate);
}