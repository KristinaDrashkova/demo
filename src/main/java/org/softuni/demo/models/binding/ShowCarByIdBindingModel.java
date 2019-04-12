package org.softuni.demo.models.binding;

import java.util.Set;

/**
 * @author kristina.drashkova
 */
public class ShowCarByIdBindingModel {
    private String make;

    private String model;

    private Long travelledDistance;

    private Set<ShowPartBindingModel> parts;

    public ShowCarByIdBindingModel() {
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

    public Set<ShowPartBindingModel> getParts() {
        return parts;
    }

    public void setParts(Set<ShowPartBindingModel> parts) {
        this.parts = parts;
    }
}
