package org.softuni.demo.controllers;

import org.softuni.demo.models.binding.ShowSupplierBindingModel;
import org.softuni.demo.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController extends BaseController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/local")
    public ModelAndView getAllLocalSuppliers() {
        ModelAndView modelAndView = view("supplier/suppliers");
        List<ShowSupplierBindingModel> suppliers = supplierService.getAllLocal();
        modelAndView.addObject("suppliers", suppliers);

        return modelAndView;
    }

    @RequestMapping("/importers")
    public ModelAndView getAllImporterSuppliers() {
        ModelAndView modelAndView = view("supplier/suppliers");
        List<ShowSupplierBindingModel> suppliers = supplierService.getAllImporters();
        modelAndView.addObject("suppliers", suppliers);

        return modelAndView;
    }
}
