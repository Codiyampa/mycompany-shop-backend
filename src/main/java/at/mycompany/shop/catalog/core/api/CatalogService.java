package at.mycompany.shop.catalog.core.api;

import at.mycompany.shop.catalog.core.model.jpa.Product;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

public interface CatalogService {
    Integer createProduct(Product product);
    Product updateProduct(Product product);
}