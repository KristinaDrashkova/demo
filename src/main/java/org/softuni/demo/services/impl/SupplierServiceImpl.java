package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.demo.models.binding.ShowSupplierBindingModel;
import org.softuni.demo.repositories.SupplierRepository;
import org.softuni.demo.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author kristina.drashkova
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ShowSupplierBindingModel> getAllLocal() {
        Type listType = new TypeToken<List<ShowSupplierBindingModel>>() {}.getType();

        return modelMapper.map(supplierRepository.findAllByIsImporter(false), listType);
    }

    @Override
    public List<ShowSupplierBindingModel> getAllImporters() {
        Type listType = new TypeToken<List<ShowSupplierBindingModel>>() {}.getType();

        return modelMapper.map(supplierRepository.findAllByIsImporter(true), listType);
    }

}
