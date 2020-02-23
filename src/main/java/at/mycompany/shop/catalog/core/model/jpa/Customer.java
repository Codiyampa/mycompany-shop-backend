package at.mycompany.shop.catalog.core.model.jpa;

/**
 * @author: Codiyampa
 * @date: 20.02.2020
 */

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.Set;

@Entity(name = "customer")
public class Customer extends AbstractBaseEntity {
    private String firstName;
    private String secondName;
    private String street;
    private Integer houseNumber;
    private Integer plz;
    private String city;
    private Set<Order> orders;

    /* getter and setter area */
    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Column(nullable = false)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(nullable = false)
    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Column(nullable = false)
    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    @Column(nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonbTransient
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "customer"
    )
    @Column(nullable = false)
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}