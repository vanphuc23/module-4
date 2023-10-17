package com.example.form_dang_ky.controller;

import com.example.form_dang_ky.dto.UserDto;
import com.example.form_dang_ky.model.User;
import com.example.form_dang_ky.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/form")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showListUser(Model model) {
        List<User> list = iUserService.findAll();
        model.addAttribute("list", list);
        return "result";
    }

    @GetMapping("/create")
    private String showCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @PostMapping("/create")
    private String create(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, Model model) {
        User user = new User();
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("userDto",userDto);
            return "index";
        }
        BeanUtils.copyProperties(userDto,user);
        iUserService.add(user);
        redirectAttributes.addFlashAttribute("mess","1");
        return "redirect:/form/create";
    }
}
