package org.softuni.demo.repositories;

import org.softuni.demo.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {
    @Query("SELECT s FROM Supplier AS s WHERE s.importer = :importer")
    List<Supplier> findAllByIsImporter(@Param(value = "importer") boolean importer);
}
