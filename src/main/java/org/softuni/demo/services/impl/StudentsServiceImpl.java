package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.softuni.demo.entities.Student;
import org.softuni.demo.models.binding.CreateStudentBindingModel;
import org.softuni.demo.repositories.StudentsRepository;
import org.softuni.demo.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author kristina.drashkova
 */
@Service
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean create(CreateStudentBindingModel createStudentBindingModel) {
        Student student = this.modelMapper.map(createStudentBindingModel, Student.class);

        return this.studentsRepository.save(student) != null;
    }

    @Override
    public Set<Student> getAll() {
        return this.studentsRepository.findAll().stream().collect(Collectors.toSet());
    }
}
