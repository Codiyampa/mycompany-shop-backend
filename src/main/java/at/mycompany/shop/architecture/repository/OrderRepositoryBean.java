package at.mycompany.shop.architecture.repository;

import at.mycompany.shop.domain.model.entity.Order;
import at.mycompany.shop.domain.model.repository.OrderRepository;

import javax.enterprise.context.Dependent;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

@Dependent
public class OrderRepositoryBean extends AbstractRepositoryBean<Order, Integer> implements OrderRepository {
    @Override
    public List<Order> findByDate(Instant beginDate, Instant endDate) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<Order> qry = getCriteriaQuery(cb);
        Root<Order> order = getRoot(qry);

        qry.select(order);
        if (beginDate != null) {
            qry.where(cb.greaterThanOrEqualTo(order.get("creationDate"), beginDate));
        }
        if (endDate != null) {
            qry.where(cb.lessThanOrEqualTo(order.get("creationDate"), endDate));
        }

        return getResultList(qry);
    }
}