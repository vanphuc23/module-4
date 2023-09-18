package com.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorServlet {
    @RequestMapping(value = "/calculator/list", method = RequestMethod.GET)
    public String show() {
        return "list";
    }

    @RequestMapping(value = "/calculator/list", method = RequestMethod.POST)
    public String list(@RequestParam int usd, Model model) {
        int vnd = usd * 24;
        String trade = "Tiền vnd: " + vnd + " VNĐ";
        model.addAttribute("vnd", trade);
        return "list";
    }
}
