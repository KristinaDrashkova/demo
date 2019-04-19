package org.softuni.demo.controllers;

import org.softuni.demo.models.binding.CreateUserBindingModel;
import org.softuni.demo.models.binding.ShowLoginBindingModel;
import org.softuni.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kristina.drashkova
 */
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView showRegister() {
        ModelAndView modelAndView = view("/user/register");
        modelAndView.addObject("register", new CreateUserBindingModel());

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(CreateUserBindingModel user) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            return redirect("/register");
        }
        userService.createUser(user);

        return redirect("/login");
    }

    @GetMapping("/login")
    public ModelAndView showLogin() {
        ModelAndView modelAndView = view("/user/login");
        modelAndView.addObject("login", new ShowLoginBindingModel());

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView showLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return redirect("/login?logout");
    }

    @RequestMapping("/welcome")
    public ModelAndView showWelcome() {
        return view("/user/welcome");
    }
}
