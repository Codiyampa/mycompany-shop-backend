package at.mycompany.shop.domain.model.entity;

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
public class Product extends AbstractBaseEntity {
    private String name;
    private BigDecimal price;
    private Set<Integer> categoryIds;
    private Set<Category> categories = new HashSet<>();
    private Set<ProductOrderAmount> productOrderAmounts;

    /* constructor area */
    public Product() { }

    public Product(String name, BigDecimal price, Set<Category> categories) {
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    /* function area */
    @PostLoad
    private void postLoad() {
        categoryIds = categories.stream().map(Category::getId).collect(Collectors.toSet());
    }

    /* getter and setter area */
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

    @JsonbTransient
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "product"
    )
    public Set<ProductOrderAmount> getProductOrderAmounts() {
        return productOrderAmounts;
    }

    public void setProductOrderAmounts(Set<ProductOrderAmount> productOrderAmounts) {
        this.productOrderAmounts = productOrderAmounts;
    }
}