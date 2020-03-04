package at.mycompany.shop.application;

import at.mycompany.shop.domain.model.entity.Product;
import at.mycompany.shop.domain.model.repository.ProductRepository;
import at.mycompany.shop.domain.service.ProductDataAccess;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

@ApplicationScoped
public class ProductDataAccessImpl implements ProductDataAccess {

    @Inject
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id);
    }
}