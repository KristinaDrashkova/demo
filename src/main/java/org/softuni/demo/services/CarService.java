package org.softuni.demo.services;

import org.softuni.demo.entities.Car;
import org.softuni.demo.models.binding.CreateCarBindingModel;
import org.softuni.demo.models.binding.ShowCarByIdBindingModel;

import java.util.List;

/**
 * @author kristina.drashkova
 */
public interface CarService {
    List<Car> getAll();

    boolean createCar();

    List<CreateCarBindingModel> getCarsOrdered(String make);

    ShowCarByIdBindingModel getCarById(Long id);
}
