package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("users",iUserService.list());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("user",new User());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute User user) {
        iUserService.create(user);
        return "redirect:/user";
    }
}
