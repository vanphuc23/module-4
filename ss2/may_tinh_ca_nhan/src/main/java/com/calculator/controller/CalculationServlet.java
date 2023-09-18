package com.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculationServlet {
    @GetMapping("listCalculator")
    public String show() {
        return "listCalculator";
    }

    @PostMapping("listCalculator")
    public String Cal(@RequestParam(defaultValue = "0") int number1,
                      @RequestParam(defaultValue = "0") int number2,
                      @RequestParam String btn, Model model) {
        try {
            if (btn.equals("Addition(+)")) {
                model.addAttribute("num", number1 + number2);
            }
            if (btn.equals("Subtraction(-)")) {
                model.addAttribute("num", number1 - number2);
            }
            if (btn.equals("Multiplication(X)")) {
                model.addAttribute("num", number1 * number2);
            }
            if (btn.equals("Division(/)")) {
                model.addAttribute("num", number1 / number2);
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        return "listCalculator";
    }
}
