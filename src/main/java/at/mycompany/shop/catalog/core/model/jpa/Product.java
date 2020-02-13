package at.mycompany.shop.catalog.core.model.jpa;

import java.math.BigDecimal;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;

    /* constructor area */
    public Product() { }

    public Product(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /* getter and setter area */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}