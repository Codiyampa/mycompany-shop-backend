package at.mycompany.shop.architecture.repository;

import at.mycompany.shop.domain.model.entity.Customer;
import at.mycompany.shop.domain.model.repository.CustomerRepository;

import javax.enterprise.context.Dependent;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

@Dependent
public class CustomerRepositoryBean extends AbstractRepositoryBean<Customer, Integer> implements CustomerRepository {
    @Override
    public Customer findByName(String firstName, String secondName) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Customer> qry = cb.createQuery(Customer.class);

            Root<Customer> customer = qry.from(Customer.class);
            qry.select(customer);
            qry.where(
                    cb.equal(customer.get("firstName"), firstName),
                    cb.equal(customer.get("secondName"), secondName)
            );

            return em.createQuery(qry).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}