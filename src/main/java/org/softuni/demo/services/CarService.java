package org.softuni.demo.services;

import org.softuni.demo.entities.Car;
import org.softuni.demo.models.binding.CreateAndShowCarBindingModel;
import org.softuni.demo.models.binding.ShowCarByIdBindingModel;

import java.util.List;

/**
 * @author kristina.drashkova
 */
public interface CarService {
    List<CreateAndShowCarBindingModel> getAll();

    boolean createCar();

    List<CreateAndShowCarBindingModel> getCarsOrdered(String make);

    ShowCarByIdBindingModel getCarById(Long id);
}
