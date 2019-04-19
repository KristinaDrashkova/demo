package org.softuni.demo.services;

import org.softuni.demo.entities.Customer;
import org.softuni.demo.models.binding.CreateAndEditCustomerBindingModel;
import org.softuni.demo.models.binding.ShowCustomerBindingModel;
import org.softuni.demo.models.binding.ShowCustomerByIdBindingModel;

import java.util.List;

/**
 * @author kristina.drashkova
 */
public interface CustomerService {
    List<Customer> getAll();

    List<ShowCustomerBindingModel> getAllOrderedByAscendingBirthDate();

    List<ShowCustomerBindingModel> getAllOrderedByDescendingBirthDate();

    ShowCustomerByIdBindingModel getCustomerById(Long id);

    ShowCustomerBindingModel getCustomerByIdEditMode(Long id);

    ShowCustomerBindingModel createCustomer(CreateAndEditCustomerBindingModel customer);

    ShowCustomerBindingModel editCustomer(Long id, CreateAndEditCustomerBindingModel customer);

    boolean existsCustomer(Long id);
}
