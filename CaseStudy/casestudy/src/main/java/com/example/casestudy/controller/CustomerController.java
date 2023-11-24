package com.example.casestudy.controller;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.customer.ICustomerTypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

//    @GetMapping("")
//    public String showListCustomer(Model model) {
//        model.addAttribute("customers", iCustomerService.listCustomer());
//        return "customer/listCustomer";
//    }

    @GetMapping("")
    public String showListCustomer(@PageableDefault(page = 0,size = 3)Pageable pageable, Model model,@RequestParam(defaultValue = "",required = false) String searchName) {
        Page<Customer> customerPage = iCustomerService.findByCustomerName(pageable,searchName);
        model.addAttribute("customers", customerPage);
        model.addAttribute("searchName",searchName);
        return "customer/listCustomer";
    }

    @GetMapping("/create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", iCustomerTypeService.listCustomerType());
        return "customer/createCustomer";
    }

    @PostMapping("/create")
    public String createNewCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.addCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Create success");
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomer(@PathVariable Long id, Model model) {
        Customer customer = iCustomerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypes", iCustomerTypeService.listCustomerType());
        return "customer/editCustomer";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.addCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Edit success");
        return "redirect:/customers";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Long customerId, RedirectAttributes redirectAttributes) {
        Customer customer = iCustomerService.findCustomerById(customerId);
        iCustomerService.deleteCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Delete success");
        return "redirect:/customers";
    }
}
