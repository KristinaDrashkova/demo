package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.demo.entities.Car;
import org.softuni.demo.entities.Part;
import org.softuni.demo.models.binding.CreateCarBindingModel;
import org.softuni.demo.models.binding.ShowCarByIdBindingModel;
import org.softuni.demo.models.binding.ShowPartBindingModel;
import org.softuni.demo.repositories.CarRepository;
import org.softuni.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author kristina.drashkova
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public boolean createCar() {
        return false;
    }

    @Override
    public List<CreateCarBindingModel> getCarsOrdered(String make) {
        Type listType = new TypeToken<List<CreateCarBindingModel>>() {}.getType();

        return modelMapper.map(carRepository.getCarsByModelAscAndTravelledDistanceDesc(make), listType);
    }

    @Override
    public ShowCarByIdBindingModel getCarById(Long id) {

        return modelMapper.map(carRepository.findById(id), ShowCarByIdBindingModel.class);
    }
}
