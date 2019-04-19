package org.softuni.demo.services;

import org.softuni.demo.models.binding.CreateUserBindingModel;
import org.softuni.demo.models.binding.ShowLoginBindingModel;

/**
 * @author kristina.drashkova
 */
public interface UserService {
    CreateUserBindingModel createUser(CreateUserBindingModel user);

    ShowLoginBindingModel findByUsername(ShowLoginBindingModel login);
}
