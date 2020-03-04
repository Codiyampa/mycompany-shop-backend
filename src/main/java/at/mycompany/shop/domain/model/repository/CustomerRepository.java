package at.mycompany.shop.domain.model.repository;

import at.mycompany.shop.domain.model.entity.Customer;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

public interface CustomerRepository extends AbstractRepository<Customer, Integer> {
    Customer findByName(String firstName, String secondName);
}