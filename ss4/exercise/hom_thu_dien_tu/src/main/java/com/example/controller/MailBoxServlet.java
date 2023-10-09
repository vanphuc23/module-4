package com.example.controller;

import com.example.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxServlet {
    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("mailBox", new MailBox());
        model.addAttribute("languages",new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("size", new String[]{"5", "10", "15", "25", "50", "100"});
        return "index";
    }
    @PostMapping("/")
    public String create(@ModelAttribute MailBox mailBox) {
        MailBox mailBox1 = mailBox;
        return "index";
    }
}
