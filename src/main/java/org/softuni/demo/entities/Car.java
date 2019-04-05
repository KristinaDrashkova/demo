package org.softuni.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
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

    @Column(name = "traveled_distance")
    private Long traveledDistance;

    @ManyToMany
    @JoinTable(name = "parts_cars",
    joinColumns = @JoinColumn(name = "part_id"),
    inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<Part> parts;
}
