package org.softuni.demo.controllers;

import org.softuni.demo.models.binding.ShowSaleBindingModel;
import org.softuni.demo.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Controller
@RequestMapping("/sales")
public class SaleController extends BaseController {
    @Autowired
    private SaleService saleService;

    @RequestMapping
    public ModelAndView getAllSales() {
        ModelAndView modelAndView = view("sales");
        List<ShowSaleBindingModel> sales = saleService.getAll();
        modelAndView.addObject("sales", sales);

        return modelAndView;
    }

    @RequestMapping("/{id}")
    public ModelAndView getSaleById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = view("sale");
        ShowSaleBindingModel sale = saleService.getSaleById(id);
        modelAndView.addObject("sale", sale);

        return modelAndView;
    }

    @RequestMapping("/discounted")
    public ModelAndView getSaleWithDiscount() {
        ModelAndView modelAndView = view("sales");
        List<ShowSaleBindingModel> sales = saleService.getSalesByDiscount(0d);
        modelAndView.addObject("sales", sales);

        return modelAndView;
    }

    @RequestMapping("/discounted/{discount}")
    public ModelAndView getSaleWithGivenDiscount(@PathVariable(value = "discount") Double discount) {
        ModelAndView modelAndView = view("sales");
        List<ShowSaleBindingModel> sales = saleService.getSalesByDiscount(discount);
        modelAndView.addObject("sales", sales);

        return modelAndView;
    }
}
