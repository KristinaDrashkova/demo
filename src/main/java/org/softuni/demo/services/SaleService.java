package org.softuni.demo.services;

import org.softuni.demo.entities.Sale;
import org.softuni.demo.models.binding.ShowSaleBindingModel;

import java.util.List;

/**
 * @author kristina.drashkova
 */
public interface SaleService {
    List<ShowSaleBindingModel> getAll();

    boolean createSale();

    ShowSaleBindingModel getSaleById(Long id);

    List<ShowSaleBindingModel> getSalesByDiscount(Double discount);
}
