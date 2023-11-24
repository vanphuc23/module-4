package com.example.dien_thoai.controller;


import com.example.dien_thoai.model.Smartphone;
import com.example.dien_thoai.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/smartphone")
public class HomeController {
    @Autowired
    private ISmartphoneService iSmartphoneService;
    @GetMapping("")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("list","smartphones",iSmartphoneService.findAll());
        return modelAndView;
    }
}
