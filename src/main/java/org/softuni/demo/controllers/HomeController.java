package org.softuni.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author kristina.drashkova
 */
@Controller
public class HomeController extends BaseController {
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("pesho", "peshkata");
        modelAndView.setViewName("index");

        List<Integer> collection = Arrays.asList(5, 7, 20, 30);

        modelAndView.addObject("collection", collection);

        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView indexPost(@RequestParam String name, @RequestParam int id) {
        System.out.println(name);
        System.out.println(id);

        return redirect("/");
    }

    @GetMapping("/test/{id}")
    public ModelAndView test(@PathVariable int id) {
        System.out.println("MY ID is: " + id);

        return redirect("/");
    }

}
