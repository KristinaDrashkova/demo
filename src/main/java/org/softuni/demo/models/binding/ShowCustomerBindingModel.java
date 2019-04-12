package org.softuni.demo.models.binding;

import java.util.Date;

/**
 * @author kristina.drashkova
 */
public class ShowCustomerBindingModel {
    private String name;

    private Date birthDate;

    private Boolean isYoungDriver;

    public ShowCustomerBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
