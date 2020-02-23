package at.mycompany.shop.catalog.core.model.jpa;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

/**
 * @author: Codiyampa
 * @date: 20.02.2020
 */

@Entity(name = "order")
@Table(name="orders")
public class Order extends AbstractBaseEntity {
    private Instant creationDate;
    private Customer customer;
    private String paymentMethod;
    private Set<ProductOrderAmount> productOrderAmounts;

    /* constructor area */
    public Order() { }

    public Order(Customer customer, String paymentMethod, Set<ProductOrderAmount> productOrderAmounts) {
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.productOrderAmounts = productOrderAmounts;
    }

    /* function area */
    @PrePersist
    protected void onCreate() {
        creationDate = Instant.now();
    }

    /* getter and setter area */
    @Column(nullable = false)
    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="customer_id", nullable=false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(nullable = false)
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Column(nullable = false)
    public Set<ProductOrderAmount> getProductOrderAmounts() {
        return productOrderAmounts;
    }

    public void setProductOrderAmounts(Set<ProductOrderAmount> productOrderAmounts) {
        this.productOrderAmounts = productOrderAmounts;
    }
}