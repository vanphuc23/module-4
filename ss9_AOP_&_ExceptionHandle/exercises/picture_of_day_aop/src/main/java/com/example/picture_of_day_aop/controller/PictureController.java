package com.example.picture_of_day_aop.controller;


import com.example.picture_of_day_aop.exception.DuplicateBadWordsException;
import com.example.picture_of_day_aop.model.Picture;
import com.example.picture_of_day_aop.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private IPictureService iPictureService;

    @GetMapping("")
    public String show(Model model, @PageableDefault(page = 0,size = 2,sort = "feedBack")Pageable pageable) {
        Page<Picture> listPage = iPictureService.findAll(pageable);
        model.addAttribute("listPage", listPage);
        model.addAttribute("picture", new Picture());
        model.addAttribute("listEvaluate", new String[]{"1", "2", "3", "4", "5"});
        return "list";
    }

    @PostMapping("")
    public String create(@ModelAttribute Picture picture) throws DuplicateBadWordsException {
        if (picture.getFeedBack().isEmpty()) {
            return "redirect:/picture";
        } else {
            iPictureService.add(picture);
            return "redirect:/picture";
        }
    }
    @GetMapping("/awesome/{id}")
    public String upAwesome(@PathVariable int id) {
        iPictureService.updateAwesome(id);
        return "redirect:/picture";
    }
    @GetMapping("/great/{id}")
    public String upGreat(@PathVariable int id) {
        iPictureService.updateGreat(id);
        return "redirect:/picture";
    }
    @ExceptionHandler(DuplicateBadWordsException.class)
    public String BadWordsException() {
        return "error_bad_word";
    }
}
