package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.demo.entities.Customer;
import org.softuni.demo.models.binding.ShowCustomerBindingModel;
import org.softuni.demo.models.binding.ShowCustomerByIdBindingModel;
import org.softuni.demo.repositories.CustomerRepository;
import org.softuni.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
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
    public boolean createCustomer() {
        return false;
    }

    @Override
    public boolean editCustomer() {
        return false;
    }
}
