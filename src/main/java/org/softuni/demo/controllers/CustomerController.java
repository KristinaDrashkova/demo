package org.softuni.demo.controllers;

import org.softuni.demo.models.binding.ShowCustomerBindingModel;
import org.softuni.demo.models.binding.ShowCustomerByIdBindingModel;
import org.softuni.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Controller
@RequestMapping("/customers")
public class CustomerController extends BaseController{

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/all/ascending")
    public ModelAndView getAllCustomersAscending() {
        ModelAndView modelAndView = view("allCustomers.html");
        List<ShowCustomerBindingModel> bindingModelList = customerService.getAllOrderedByAscendingBirthDate();
        modelAndView.addObject("customers", bindingModelList);

        return modelAndView;
    }


    @RequestMapping(value = "/all/descending")
    public ModelAndView getAllCustomersDesc() {
        ModelAndView modelAndView = view("allCustomers");
        List<ShowCustomerBindingModel> bindingModelList = customerService.getAllOrderedByDescendingBirthDate();
        modelAndView.addObject("customers", bindingModelList);

        return modelAndView;
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView getCustomerById(@PathVariable("id") Long id) {
        ModelAndView modelAndView = view("customerById");
        ShowCustomerByIdBindingModel customer = customerService.getCustomerById(id);
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }
}
