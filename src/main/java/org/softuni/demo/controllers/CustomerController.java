package org.softuni.demo.controllers;

import org.softuni.demo.entities.Customer;
import org.softuni.demo.models.binding.CreateAndEditCustomerBindingModel;
import org.softuni.demo.models.binding.ShowCustomerBindingModel;
import org.softuni.demo.models.binding.ShowCustomerByIdBindingModel;
import org.softuni.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        ModelAndView modelAndView = view("customer/allCustomers");
        List<ShowCustomerBindingModel> bindingModelList = customerService.getAllOrderedByAscendingBirthDate();
        modelAndView.addObject("customers", bindingModelList);

        return modelAndView;
    }


    @RequestMapping("/all/descending")
    public ModelAndView getAllCustomersDesc() {
        ModelAndView modelAndView = view("customer/allCustomers");
        List<ShowCustomerBindingModel> bindingModelList = customerService.getAllOrderedByDescendingBirthDate();
        modelAndView.addObject("customers", bindingModelList);

        return modelAndView;
    }

    @RequestMapping("/{id}")
    public ModelAndView getCustomerById(@PathVariable("id") Long id) {
        ModelAndView modelAndView = view("customer/customerById");
        ShowCustomerByIdBindingModel customer = customerService.getCustomerById(id);
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage(){
        ModelAndView modelAndView = view("customer/createCustomer");
        modelAndView.addObject("customer", new CreateAndEditCustomerBindingModel());

        return modelAndView;

    }

    @PostMapping("/create")
    public ModelAndView createCustomer(CreateAndEditCustomerBindingModel customer) {
        customerService.createCustomer(customer);

        return redirect("/");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditCustomer(@PathVariable Long id){
        if (!customerService.existsCustomer(id)) {
            return redirect("commons/error");
        }
        ModelAndView modelAndView = view("customer/editCustomer");
        modelAndView.addObject("customer", customerService.getCustomerByIdEditMode(id));

        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable Long id, CreateAndEditCustomerBindingModel customer) {
        customerService.editCustomer(id, customer);

        return redirect("/");
    }
}
