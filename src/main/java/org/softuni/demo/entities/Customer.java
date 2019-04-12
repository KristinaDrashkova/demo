package org.softuni.demo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author kristina.drashkova
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "is_young_driver")
    private Boolean youngDriver;

    @OneToMany(mappedBy = "customer")
    private Set<Sale> sales;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return youngDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        this.youngDriver = youngDriver;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
