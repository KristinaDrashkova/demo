package org.softuni.demo.repositories;

import org.softuni.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kristina.drashkova
 */
@Repository
public interface StudentsRepository extends JpaRepository<Student, String> {
}