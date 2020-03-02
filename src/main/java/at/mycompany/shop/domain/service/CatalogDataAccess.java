package at.mycompany.shop.domain.service;

import at.mycompany.shop.domain.model.entity.Order;
import at.mycompany.shop.domain.model.entity.Product;

import java.util.List;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

public interface CatalogDataAccess {
    List<Product> getProducts();
    Product getProductById(Integer id);
    List<Order> getOrders();
    Order getOrderById(Integer id);
}