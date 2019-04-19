package org.softuni.demo.repositories;

import org.softuni.demo.entities.Part;
import org.softuni.demo.models.binding.CreateAndShowPartBindingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kristina.drashkova
 */
@Repository
public interface PartRepository extends JpaRepository<Part, String> {
    Part findById(Long id);
}
