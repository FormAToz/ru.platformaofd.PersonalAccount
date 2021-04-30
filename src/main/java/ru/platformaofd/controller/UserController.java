package ru.platformaofd.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.platformaofd.model.enums.BalanceType;
import ru.platformaofd.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String login, @RequestParam String password) {
        userService.login(login, password);
        return getUserDetails();
    }

    @GetMapping("/logout")
    @PreAuthorize("hasAuthority('user:write')")
    public ModelAndView logout() {
        return new ModelAndView("donePage", "response", userService.logout());
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestParam String login, @RequestParam String password) {
        return new ModelAndView("donePage", "response", userService.register(login, password));
    }

    @GetMapping("/details")
    @PreAuthorize("hasAuthority('user:write')")
    public ModelAndView getUserDetails() {
        ModelAndView modelAndView = new ModelAndView("userDetails");
        modelAndView.addObject("types", BalanceType.values());
        modelAndView.addObject("user", userService.getLoggedUser());
        return modelAndView;
    }

    @PostMapping("/details")
    @PreAuthorize("hasAuthority('user:write')")
    public ModelAndView createNewBalance(@RequestParam BalanceType type, @RequestParam long count) {
        return new ModelAndView("donePage", "response", userService.addNewBalance(type, count));
    }
}