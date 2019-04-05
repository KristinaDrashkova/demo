package org.softuni.demo.services;

import org.softuni.demo.entities.Student;
import org.softuni.demo.models.binding.CreateStudentBindingModel;

import java.util.Set;

/**
 * @author kristina.drashkova
 */
public interface StudentsService {
    boolean create(CreateStudentBindingModel createStudentBindingModel);

    Set<Student> getAll();
}
