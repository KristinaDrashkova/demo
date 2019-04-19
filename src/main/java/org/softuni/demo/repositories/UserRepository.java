package org.softuni.demo.repositories;

import org.softuni.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kristina.drashkova
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
