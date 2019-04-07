package org.softuni.demo.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * @author kristina.drashkova
 */
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private String make;

    private String model;

    @Column(name = "travelled_distance")
    private Long traveledDistance;

    @ManyToMany
    @JoinTable(name = "parts_cars",
    joinColumns = @JoinColumn(name = "part_id"),
    inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<Part> parts;

    @OneToOne(mappedBy = "carId")
    private Sale sale;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTraveledDistance() {
        return traveledDistance;
    }

    public void setTraveledDistance(Long traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
