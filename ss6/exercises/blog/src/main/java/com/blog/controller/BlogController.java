package com.blog.controller;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogRepository iBlogRepository;

    @GetMapping("")
    public String showListBlog(Model model) {
        List<Blog> list = iBlogRepository.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogRepository.add(blog);
        redirectAttributes.addFlashAttribute("mess", "ADD SUCCESS");
        return "redirect:/blog";
    }

    @GetMapping("/read/{id}")
    public String showRead(@PathVariable int id, Model model) {
        Blog blog = iBlogRepository.read(id);
        model.addAttribute("blog", blog);
        return "read";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam int id, Model model) {
        Blog blogUpdate = iBlogRepository.read(id);
        model.addAttribute("blogUpdate", blogUpdate);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogRepository.update(blog, blog.getId());
        redirectAttributes.addFlashAttribute("mess", "UPDATE SUCCESS");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        iBlogRepository.delete(id);
        redirectAttributes.addFlashAttribute("mess", "DELETE SUCCESS");
        return "redirect:/blog";
    }
}
