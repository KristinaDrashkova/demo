package org.softuni.demo.repositories;

import org.softuni.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("SELECT c FROM Customer AS c ORDER BY c.birthDate ASC, c.youngDriver")
    List<Customer> findAllOrderByAscBirthDate();

    @Query("SELECT c FROM Customer AS c ORDER BY c.birthDate DESC, c.youngDriver")
    List<Customer> findAllOrderByDescBirthDate();

    Customer findById(Long id);
}
