package org.softuni.demo.entities;

import javax.persistence.*;

/**
 * @author kristina.drashkova
 */
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private Double discount;

    @OneToOne(targetEntity = Car.class)
    private Long carId;

    @ManyToOne(targetEntity = Customer.class)
    private Long customerId;

    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
