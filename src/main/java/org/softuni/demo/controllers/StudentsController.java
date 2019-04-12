package org.softuni.demo.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kristina.drashkova
 */
@Controller
@RequestMapping("/students")
public class StudentsController extends BaseController {

    @PostMapping("/create")
    public ModelAndView createStudent() {

        return this.redirect("all");
    }

    @ResponseBody
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> allStudents() {
        List<String> students = new ArrayList<>();
        students.add("No students");
        return students;
    }
}
