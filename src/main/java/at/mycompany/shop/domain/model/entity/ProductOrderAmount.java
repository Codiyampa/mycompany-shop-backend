package at.mycompany.shop.domain.model.entity;

/**
 * @author: Codiyampa
 * @date: 20.02.2020
 */

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "product_order_amount")
public class ProductOrderAmount extends AbstractBaseEntity {
    private Order order;
    private Product product;
    private Integer amount;

    /* getter and setter area */
    @JsonbTransient
    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(nullable = false)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}