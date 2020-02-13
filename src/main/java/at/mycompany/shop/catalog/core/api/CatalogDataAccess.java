package at.mycompany.shop.catalog.core.api;

import at.mycompany.shop.catalog.core.model.jpa.Product;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

public interface CatalogDataAccess {
    Product getProductById(Integer id);
}