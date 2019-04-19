package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.demo.entities.Car;
import org.softuni.demo.entities.Part;
import org.softuni.demo.models.binding.CreateAndShowCarBindingModel;
import org.softuni.demo.models.binding.ShowCarByIdBindingModel;
import org.softuni.demo.repositories.CarRepository;
import org.softuni.demo.repositories.PartRepository;
import org.softuni.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kristina.drashkova
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CreateAndShowCarBindingModel> getAll() {
        Type listType = new TypeToken<List<CreateAndShowCarBindingModel>>() {
        }.getType();

        return modelMapper.map(carRepository.findAll(), listType);
    }

    @Override
    public CreateAndShowCarBindingModel createCar(CreateAndShowCarBindingModel car) {
        Car carToCreate = new Car();
        carToCreate.setMake(car.getMake());
        carToCreate.setModel(car.getModel());
        carToCreate.setTravelledDistance(car.getTravelledDistance());
        Set<Part> parts = new HashSet<>();
        for (Long partId : car.getParts()) {
            parts.add(partRepository.findById(partId));
        }

        carToCreate.setParts(parts);
        return modelMapper.map(carRepository.save(carToCreate), CreateAndShowCarBindingModel.class);
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
