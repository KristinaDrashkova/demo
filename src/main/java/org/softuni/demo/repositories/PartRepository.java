package org.softuni.demo.repositories;

import org.softuni.demo.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kristina.drashkova
 */
@Repository
public interface PartRepository extends JpaRepository<Part, String> {
}
