package com.picture.controller;

import com.picture.model.Picture;
import com.picture.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private IPictureRepository iPictureRepository;

    @GetMapping("")
    public String show(Model model) {
        List<Picture> list = iPictureRepository.findAll();
        model.addAttribute("list", list);
        model.addAttribute("picture", new Picture());
        model.addAttribute("listEvaluate", new String[]{"1", "2", "3", "4", "5"});
        return "list";
    }

    @PostMapping("")
    public String create(@ModelAttribute Picture picture) {
        if (picture.getFeedBack().isEmpty()) {
            return "redirect:/picture";
        } else {
            iPictureRepository.add(picture);
            return "redirect:/picture";
        }
    }
    @GetMapping("/awesome/{id}")
    public String upAwesome(@PathVariable int id) {
        iPictureRepository.updateAwesome(id);
        return "redirect:/picture";
    }
    @GetMapping("/great/{id}")
    public String upGreat(@PathVariable int id) {
        iPictureRepository.updateGreat(id);
        return "redirect:/picture";
    }
}
