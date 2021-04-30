package ru.platformaofd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView homePage(Principal principal) {
        return new ModelAndView("homePage", "principal", principal);
    }

    @GetMapping("/registration")
    public ModelAndView registerPage() {
        return new ModelAndView("registerPage");
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("loginPage");
    }
}
