package org.softuni.demo.controllers;

import org.softuni.demo.models.binding.CreateStudentBindingModel;
import org.softuni.demo.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * @author kristina.drashkova
 */
@Controller
@RequestMapping("/students")
public class StudentsController extends BaseController {

    @Autowired
    private StudentsService studentsService;

    @PostMapping("/create")
    public ModelAndView createStudent(CreateStudentBindingModel createStudentBindingModel) {
        this.studentsService.create(createStudentBindingModel);

        return this.redirect("all");
    }

    @ResponseBody
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Student> allStudents() {
        return this.studentsService.getAll();
    }
}
