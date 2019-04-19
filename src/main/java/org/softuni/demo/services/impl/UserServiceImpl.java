package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.softuni.demo.entities.User;
import org.softuni.demo.models.binding.CreateUserBindingModel;
import org.softuni.demo.models.binding.ShowLoginBindingModel;
import org.softuni.demo.repositories.UserRepository;
import org.softuni.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author kristina.drashkova
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public CreateUserBindingModel createUser(CreateUserBindingModel user) {
        User userToCreate = modelMapper.map(user, User.class);
        userToCreate.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return modelMapper.map(userRepository.save(userToCreate), CreateUserBindingModel.class);
    }

    @Override
    public ShowLoginBindingModel findByUsername(ShowLoginBindingModel login) {
        return modelMapper.map(userRepository.findByUsername(login.getUsername()), ShowLoginBindingModel.class);
    }
}
