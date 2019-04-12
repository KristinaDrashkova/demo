package org.softuni.demo.services;

import org.softuni.demo.entities.Supplier;
import org.softuni.demo.models.binding.ShowSupplierBindingModel;

import java.util.List;

/**
 * @author kristina.drashkova
 */
public interface SupplierService {
    List<ShowSupplierBindingModel> getAllLocal();

    List<ShowSupplierBindingModel> getAllImporters();
}
