package ru.platformaofd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView homePage(Model model) {
        return new ModelAndView("homePage");
    }

    @GetMapping("/registration")
    public ModelAndView registerPage(Model model) {
        return new ModelAndView("registerPage");
    }

    @GetMapping("/login")
    public ModelAndView loginPage(Model model) {
        return new ModelAndView("loginPage");
    }
}
