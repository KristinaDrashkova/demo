package org.softuni.demo.controllers;

import org.softuni.demo.models.binding.CreateAndShowCarBindingModel;
import org.softuni.demo.models.binding.ShowCarByIdBindingModel;
import org.softuni.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/{make}")
    public ModelAndView getCarsByMake(@PathVariable("make") String make) {
        ModelAndView modelAndView = view("cars");
        List<CreateAndShowCarBindingModel> cars = carService.getCarsOrdered(make);
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }

    @RequestMapping("/{id}/parts")
    public ModelAndView getCarById(@PathVariable("id") Long id) {
        ModelAndView modelAndView = view("carById");
        ShowCarByIdBindingModel car = carService.getCarById(id);
        modelAndView.addObject("car", car);

        return modelAndView;
    }

    @RequestMapping("/all")
    public ModelAndView getAllCars() {
        ModelAndView modelAndView = view("cars");
        List<CreateAndShowCarBindingModel> cars = carService.getAll();
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }
}
