package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.demo.entities.Car;
import org.softuni.demo.models.binding.CreateAndShowCarBindingModel;
import org.softuni.demo.models.binding.ShowCarByIdBindingModel;
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
    public List<CreateAndShowCarBindingModel> getAll() {
        Type listType = new TypeToken<List<CreateAndShowCarBindingModel>>() {
        }.getType();

        return modelMapper.map(carRepository.findAll(), listType);
    }

    @Override
    public boolean createCar() {
        return false;
    }

    @Override
    public List<CreateAndShowCarBindingModel> getCarsOrdered(String make) {
        Type listType = new TypeToken<List<CreateAndShowCarBindingModel>>() {
        }.getType();

        return modelMapper.map(carRepository.getCarsByModelAscAndTravelledDistanceDesc(make), listType);
    }

    @Override
    public ShowCarByIdBindingModel getCarById(Long id) {

        return modelMapper.map(carRepository.findById(id), ShowCarByIdBindingModel.class);
    }
}
