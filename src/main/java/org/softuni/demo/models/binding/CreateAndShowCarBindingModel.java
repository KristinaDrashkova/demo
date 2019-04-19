package org.softuni.demo.models.binding;

import org.softuni.demo.entities.Part;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kristina.drashkova
 */
public class CreateAndShowCarBindingModel {
    private String make;

    private String model;

    private Long travelledDistance;

    private Set<Long> parts;

    public CreateAndShowCarBindingModel() {
        parts = new HashSet<>();
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

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<Long> getParts() {
        return parts;
    }

    public void setParts(Set<Long> parts) {
        this.parts = parts;
    }
}
