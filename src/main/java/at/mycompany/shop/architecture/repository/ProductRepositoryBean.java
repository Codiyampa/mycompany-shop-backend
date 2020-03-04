package at.mycompany.shop.architecture.repository;

import at.mycompany.shop.domain.model.entity.Product;
import at.mycompany.shop.domain.model.repository.ProductRepository;

import javax.enterprise.context.Dependent;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

@Dependent
public class ProductRepositoryBean extends AbstractRepositoryBean<Product, Integer> implements ProductRepository {

}