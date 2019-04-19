package org.softuni.demo.models.binding;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author kristina.drashkova
 */
public class ShowCustomerBindingModel {
    private String name;

    private LocalDate birthDate;

    private Boolean isYoungDriver;

    public ShowCustomerBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
