package at.mycompany.shop.catalog.core.impl;

import at.mycompany.shop.catalog.core.api.CatalogService;
import at.mycompany.shop.catalog.core.model.jpa.Product;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@ApplicationScoped
public class CatalogServiceImpl implements CatalogService {

    @Override
    public void saveProductById(Product product, Integer id) {

    }
}