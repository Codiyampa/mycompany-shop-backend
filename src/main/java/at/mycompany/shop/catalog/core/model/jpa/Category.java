package at.mycompany.shop.catalog.core.model.jpa;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    private Integer id;
    private String name;
    private Set<Product> products = new HashSet<>();

    /* constructor area */
    public Category() { }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /* getter and setter area */
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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