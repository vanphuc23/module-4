package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String list(Model model) {
        List<Product> productList = iProductService.show();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.add(product);
        redirectAttributes.addFlashAttribute("mess", "Add success");
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("mess", "Update success");
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iProductService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete success");
        return "redirect:/products";
    }

    @GetMapping("/see")
    public ModelAndView showProduct(@RequestParam int id) {
        Product product = iProductService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/see", "product", product);
        return modelAndView;
    }

    @PostMapping("/search")
    public String see(@RequestParam String search, RedirectAttributes redirectAttributes, Model model) {
        List<Product> productList = iProductService.search(search);
        if (productList.size() == 0) {
            redirectAttributes.addFlashAttribute("eror", "NOT FOUND");
            return "redirect:/products";
        } else {
            model.addAttribute("productList", productList);
            return "list";
        }
    }
}
