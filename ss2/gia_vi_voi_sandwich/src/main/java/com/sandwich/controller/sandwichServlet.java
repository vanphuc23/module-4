package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class sandwichServlet {
    @GetMapping("listSandwich")
    public String show() {
        return "listSandwich";
    }
    @PostMapping("listSandwich")
    public String save(@RequestParam(name = "condiments", required = false, defaultValue = "Không có gia vị") String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        return "listSandwich";
    }
}
