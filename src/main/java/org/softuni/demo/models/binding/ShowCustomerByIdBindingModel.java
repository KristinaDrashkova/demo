package org.softuni.demo.models.binding;

/**
 * @author kristina.drashkova
 */
public class ShowCustomerByIdBindingModel {
    private String name;

    private Long carsBought;

    private Double totalMoneySpent;

    public ShowCustomerByIdBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCarsBought() {
        return carsBought;
    }

    public void setCarsBought(Long carsBought) {
        this.carsBought = carsBought;
    }

    public Double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public void setTotalMoneySpent(Double totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }
}
