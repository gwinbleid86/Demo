package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.services.ArticleService;
import com.example.demo.services.UserService;
import com.example.demo.util.UserAlreadyRegisteredException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ArticleService articleService;

    @GetMapping("/register")
    public String registration(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new UserDTO());
        }
        return "/register";
    }

    @PostMapping("/register")
    public String addUser(UserDTO form, RedirectAttributes attribute) throws UserAlreadyRegisteredException {
        if (userService.checkUser(form)) {
            attribute.addFlashAttribute("form", form);
            return "redirect:/users/register";
        } else {
            userService.saveUser(form);
            return "redirect:/";
        }
    }


    @GetMapping("/main")
    public String listOfUsers(
            Model model,
            @PageableDefault Pageable pageable
    ) {
        model.addAttribute("users", userService.getAllUsers(pageable));
        model.addAttribute("url", "/main");
        return "users";
    }

    @GetMapping("/detail/{id}")
    public String userInfo(
            Model model,
            @PathVariable("id") int id,
            @PageableDefault(sort = {"title"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("articles", articleService.getArticlesFromUser(id, pageable));
        model.addAttribute("url", "/detail/{id}");
        return "detail";
    }
}
