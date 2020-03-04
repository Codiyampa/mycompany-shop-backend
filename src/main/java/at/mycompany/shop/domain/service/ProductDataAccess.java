package at.mycompany.shop.domain.service;

import at.mycompany.shop.domain.model.entity.Product;

import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

public interface ProductDataAccess {
    List<Product> getProducts();
    Product getProductById(Integer id);
}