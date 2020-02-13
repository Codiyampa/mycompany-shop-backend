package at.mycompany.shop.catalog.core.model.jpa;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Codiyampa
 * @date: 13.02.2020
 */

@Entity
public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Set<Integer> categoryIds;
    private Set<Category> categories = new HashSet<>();

    /* constructor area */
    public Product() { }

    public Product(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /* functions area */
    @PostLoad
    private void postLoad() {
        categoryIds = categories.stream().map(Category::getId).collect(Collectors.toSet());
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

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Transient
    public Set<Integer> getCategoryIds() {
        return categoryIds;
    }

    @JsonbTransient
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}