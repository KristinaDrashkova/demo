package org.softuni.demo.models.binding;

/**
 * @author kristina.drashkova
 */
public class AddSaleBindingModel {
    private Double discount;

    private Long carId;

    private Long customerId;

    public AddSaleBindingModel() {
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
