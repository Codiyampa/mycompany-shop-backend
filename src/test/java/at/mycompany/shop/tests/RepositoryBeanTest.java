package at.mycompany.shop.tests;

import at.mycompany.shop.domain.model.entity.Customer;
import at.mycompany.shop.domain.model.entity.Order;
import at.mycompany.shop.domain.model.repository.CustomerRepository;
import at.mycompany.shop.domain.model.repository.OrderRepository;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

/**
 * @author: Codiyampa
 * @date: 04.03.2020
 */

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class RepositoryBeanTest {

    @Inject
    OrderRepository orderRepository;
    @Inject
    CustomerRepository customerRepository;

    @Test
    public void testOrderFindByDate() {
        LocalDate localDate = LocalDate.parse("2020-01-01");
        Instant beginDate = localDate.atStartOfDay(ZoneId.of("Europe/Vienna")).toInstant();
        localDate = LocalDate.parse("2020-12-31");
        Instant endDate = localDate.atStartOfDay(ZoneId.of("Europe/Vienna")).toInstant();

        List<Order> filteredOrders = orderRepository.findByDate(beginDate, endDate);
        Assertions.assertEquals(filteredOrders.size(), 1);
    }

    @Test
    public void testCustomerFindByName() {
        Customer customer = customerRepository.findByName("Max", "Mustermann");
        Assertions.assertNotNull(customer);

        Customer notExistingCustomer = customerRepository.findByName("123456", "Mustermann");
        Assertions.assertNull(notExistingCustomer);
    }
}