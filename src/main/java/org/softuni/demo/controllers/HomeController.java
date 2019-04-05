package org.softuni.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kristina.drashkova
 */
@Controller
public class HomeController extends BaseController{

    @GetMapping("/")
    public ModelAndView index() {
        return this.view("index.html");
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
