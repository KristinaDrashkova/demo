package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.demo.entities.Customer;
import org.softuni.demo.models.binding.CreateAndEditCustomerBindingModel;
import org.softuni.demo.models.binding.ShowCustomerBindingModel;
import org.softuni.demo.models.binding.ShowCustomerByIdBindingModel;
import org.softuni.demo.repositories.CustomerRepository;
import org.softuni.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * @author kristina.drashkova
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<ShowCustomerBindingModel> getAllOrderedByAscendingBirthDate() {
        Type listType = new TypeToken<List<ShowCustomerBindingModel>>() {}.getType();

        return modelMapper.map(customerRepository.findAllOrderByAscBirthDate(), listType);
    }

    @Override
    public List<ShowCustomerBindingModel> getAllOrderedByDescendingBirthDate() {
        Type listType = new TypeToken<List<ShowCustomerBindingModel>>() {}.getType();

        return modelMapper.map(customerRepository.findAllOrderByDescBirthDate(), listType);
    }

    @Override
    public ShowCustomerByIdBindingModel getCustomerById(Long id) {
        return modelMapper.map(customerRepository.findById(id), ShowCustomerByIdBindingModel.class);
    }

    @Override
    public ShowCustomerBindingModel getCustomerByIdEditMode(Long id) {
        return modelMapper.map(customerRepository.findById(id), ShowCustomerBindingModel.class);
    }

    @Override
    public ShowCustomerBindingModel createCustomer(CreateAndEditCustomerBindingModel customer) {
        Customer customerToSave = modelMapper.map(customer, Customer.class);

        LocalDate now = LocalDate.now();
        Period period = Period.between(customer.getBirthDate(), now);
        int years = period.getYears();
        Boolean isYoungDriver = years < 20;

        customerToSave.setYoungDriver(isYoungDriver);
        return modelMapper.map(customerRepository.save(customerToSave), ShowCustomerBindingModel.class);
    }

    @Override
    public ShowCustomerBindingModel editCustomer(Long id, CreateAndEditCustomerBindingModel customer) {
        Customer customerToUpdate = customerRepository.findById(id);
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setBirthDate(customer.getBirthDate());

        return modelMapper.map(customerRepository.save(customerToUpdate), ShowCustomerBindingModel.class);
    }

    @Override
    public boolean existsCustomer(Long id) {
        return customerRepository.findById(id) != null;
    }
}
