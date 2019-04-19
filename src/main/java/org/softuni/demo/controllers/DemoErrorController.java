package org.softuni.demo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kristina.drashkova
 */
@Controller
public class DemoErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "/commons/error";
    }

    @Override
    public String getErrorPath() {
        return "ERROR!";
    }
}
