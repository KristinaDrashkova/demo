package org.softuni.demo.controllers;

import org.softuni.demo.models.binding.CreateAndShowPartBindingModel;
import org.softuni.demo.models.binding.EditPartBindingModel;
import org.softuni.demo.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kristina.drashkova
 */
@Controller
@RequestMapping("/parts")
public class PartController extends BaseController {
    @Autowired
    private PartService partService;

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = view("part/createPart");
        modelAndView.addObject("part", new CreateAndShowPartBindingModel());

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createPart(CreateAndShowPartBindingModel part) {
        partService.createPart(part);

        return redirect("/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeletePart(@PathVariable Long id) {
        ModelAndView modelAndView = view("part/deletePart");
        modelAndView.addObject("part", partService.getPartById(id));

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deletePart(@PathVariable Long id) {
        partService.deletePart(id);

        return redirect("/");
    }

    @RequestMapping("/all")
    public ModelAndView showAllParts() {
        ModelAndView modelAndView = view("part/allParts");
        modelAndView.addObject("parts", partService.getAll());

        return modelAndView;
    }

    @RequestMapping("/{id}")
    public ModelAndView partById(@PathVariable Long id) {
        ModelAndView modelAndView = view("part/partById");
        modelAndView.addObject("part", partService.getPartById(id));

        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEditPart(@PathVariable Long id) {
        if (!partService.exists(id)) {
            redirect("/");
        }
        ModelAndView modelAndView = view("part/editPart");
        modelAndView.addObject("part", partService.getPartById(id));

        return modelAndView;
    }

    @PostMapping("edit/{id}")
    public ModelAndView editPart(@PathVariable Long id, EditPartBindingModel part) {
        partService.editPart(id, part);

        return redirect("/");
    }
}
