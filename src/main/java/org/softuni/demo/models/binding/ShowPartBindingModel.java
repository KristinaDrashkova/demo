package org.softuni.demo.models.binding;

/**
 * @author kristina.drashkova
 */
public class ShowPartBindingModel {
    private String name;

    private Double price;

    public ShowPartBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
