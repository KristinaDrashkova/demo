package org.softuni.demo.repositories;

import org.softuni.demo.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {
    Sale findById(Long id);

    List<Sale> findByDiscountAfter(Double discount);

    List<Sale> findByDiscount(Double discount);
}
