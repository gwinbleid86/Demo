package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.services.UserService;
import com.example.demo.util.UserAlreadyRegisteredException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private final UserService service;

    @GetMapping("/register")
    public String registration(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new UserDTO());
        }
        return "/register";
    }

    @PostMapping("/register")
    public String addUser(UserDTO form) throws UserAlreadyRegisteredException {
        service.saveUser(form);
        return "redirect:/";
    }

}
