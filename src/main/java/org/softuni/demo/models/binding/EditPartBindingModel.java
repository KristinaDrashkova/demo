package org.softuni.demo.models.binding;

/**
 * @author kristina.drashkova
 */
public class EditPartBindingModel {
    private Double price;

    private Long quantity;

    public EditPartBindingModel() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
