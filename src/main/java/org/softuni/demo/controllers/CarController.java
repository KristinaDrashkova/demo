package org.softuni.demo.controllers;

import org.softuni.demo.models.binding.CreateAndShowCarBindingModel;
import org.softuni.demo.models.binding.ShowCarByIdBindingModel;
import org.softuni.demo.services.CarService;
import org.softuni.demo.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Controller
@RequestMapping("/cars")
public class CarController extends BaseController {
    @Autowired
    private CarService carService;

    @Autowired
    private PartService partService;

    @RequestMapping("/{make}")
    public ModelAndView getCarsByMake(@PathVariable("make") String make) {
        ModelAndView modelAndView = view("car/allCars");
        List<CreateAndShowCarBindingModel> cars = carService.getCarsOrdered(make);
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }

    @RequestMapping("/{id}/parts")
    public ModelAndView getCarById(@PathVariable("id") Long id) {
        ModelAndView modelAndView = view("car/carById");
        ShowCarByIdBindingModel car = carService.getCarById(id);
        modelAndView.addObject("car", car);

        return modelAndView;
    }

    @RequestMapping("/all")
    public ModelAndView getAllCars() {
        ModelAndView modelAndView = view("car/allCars");
        List<CreateAndShowCarBindingModel> cars = carService.getAll();
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateCar() {
        ModelAndView modelAndView = view("car/createCar");
        modelAndView.addObject("car", new CreateAndShowCarBindingModel());
        modelAndView.addObject("predefinedPartsList", partService.getAll());

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCar(CreateAndShowCarBindingModel car) {
        carService.createCar(car);

        return redirect("/");
    }

}
