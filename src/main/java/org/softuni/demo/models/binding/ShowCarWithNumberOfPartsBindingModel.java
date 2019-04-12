package org.softuni.demo.models.binding;

/**
 * @author kristina.drashkova
 */
public class ShowCarWithNumberOfPartsBindingModel {
    private String make;

    private String model;

    private Long traveledDistance;

    private Integer partsOffered;

    public ShowCarWithNumberOfPartsBindingModel() {
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

    public Integer getPartsOffered() {
        return partsOffered;
    }

    public void setPartsOffered(Integer partsOffered) {
        this.partsOffered = partsOffered;
    }
}

