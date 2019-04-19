package org.softuni.demo.models.binding;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author kristina.drashkova
 */
public class CreateAndEditCustomerBindingModel {
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public CreateAndEditCustomerBindingModel() {
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
}
