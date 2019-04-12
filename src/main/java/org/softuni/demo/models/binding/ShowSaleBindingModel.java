package org.softuni.demo.models.binding;

/**
 * @author kristina.drashkova
 */
public class ShowSaleBindingModel {
    private ShowCarByIdBindingModel car;

    private ShowCustomerNameBindingModel customer;

    public ShowSaleBindingModel() {
    }

    public ShowCarByIdBindingModel getCar() {
        return car;
    }

    public void setCar(ShowCarByIdBindingModel car) {
        this.car = car;
    }

    public ShowCustomerNameBindingModel getCustomer() {
        return customer;
    }

    public void setCustomer(ShowCustomerNameBindingModel customer) {
        this.customer = customer;
    }
}
