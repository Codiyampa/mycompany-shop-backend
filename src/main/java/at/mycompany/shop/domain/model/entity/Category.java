package at.mycompany.shop.domain.model.entity;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category extends AbstractBaseEntity {
    private String name;
    private Set<Product> products = new HashSet<>();

    /* constructor area */
    public Category() { }

    public Category(String name) {
        this.name = name;
    }

    /* getter and setter area */
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonbTransient
    @ManyToMany(mappedBy = "categories")
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}