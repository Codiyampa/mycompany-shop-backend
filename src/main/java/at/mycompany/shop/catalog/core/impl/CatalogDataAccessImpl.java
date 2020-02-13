package at.mycompany.shop.catalog.core.impl;

import at.mycompany.shop.catalog.core.api.CatalogDataAccess;
import at.mycompany.shop.catalog.core.model.jpa.Product;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@ApplicationScoped
public class CatalogDataAccessImpl implements CatalogDataAccess {

    @Override
    public Product getProductById(Integer id) {
        return null;
    }
}