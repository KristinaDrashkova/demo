package org.softuni.demo.repositories;

import org.softuni.demo.entities.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    @Query("SELECT c FROM Car AS c WHERE c.make = :make ORDER BY c.model, c.travelledDistance DESC")
    List<Car> getCarsByModelAscAndTravelledDistanceDesc(@Param(value = "make") String make);

    Car findById( Long id);
}
