package at.mycompany.shop.catalog.core.api;

import at.mycompany.shop.catalog.core.model.jpa.Order;
import at.mycompany.shop.catalog.core.model.jpa.Product;

import java.util.List;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

public interface CatalogDataAccess {
    List<Product> getProducts();
    Product getProductById(Integer id);
    Order getOrderById(Integer id);
}