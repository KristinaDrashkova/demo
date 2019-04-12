package org.softuni.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.demo.entities.Sale;
import org.softuni.demo.models.binding.ShowSaleBindingModel;
import org.softuni.demo.repositories.SaleRepository;
import org.softuni.demo.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author kristina.drashkova
 */
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ShowSaleBindingModel> getAll() {
        Type listType = new TypeToken<List<ShowSaleBindingModel>>() {
        }.getType();

        return modelMapper.map(saleRepository.findAll(), listType);
    }

    @Override
    public boolean createSale() {
        return false;
    }

    @Override
    public ShowSaleBindingModel getSaleById(Long id) {
        return modelMapper.map(saleRepository.findById(id), ShowSaleBindingModel.class);
    }

    @Override
    public List<ShowSaleBindingModel> getSalesByDiscount(Double discount) {
        Type listType = new TypeToken<List<ShowSaleBindingModel>>() {
        }.getType();

        if (discount == 0) {
            return modelMapper.map(saleRepository.findByDiscountAfter(discount), listType);
        } else {
            return modelMapper.map(saleRepository.findByDiscount(discount), listType);
        }
    }
}
