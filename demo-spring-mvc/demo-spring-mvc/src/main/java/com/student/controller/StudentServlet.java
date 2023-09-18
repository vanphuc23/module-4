package com.student.controller;

import com.student.model.Student;
import com.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentServlet {
    @Autowired
    private IStudentService iStudentService;

    //    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
//    public String showList(ModelMap modelMap) {
//        List<Student> list = iStudentService.display();
//        modelMap.addAttribute("list", list);
//        return "list";
//    }
    @GetMapping("/student/list")
    public ModelAndView showList(Model model) {
        List<Student> list = iStudentService.display();
        ModelAndView modelAndView = new ModelAndView("list", "list", list);
        String message = (String) model.asMap().get("message");
        modelAndView.addObject("message",message);
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    //    @RequestMapping(value = "/student/create", method = RequestMethod.GET)
    @GetMapping("/student/create")
    public String showCreate() {
        return "create";
    }

    //    @RequestMapping(value = "/student/create", method = RequestMethod.POST)
    @PostMapping("/student/create")
    public String create(@RequestParam int id, @RequestParam String name, RedirectAttributes redirectAttributes) {
        Student student = new Student(id, name);
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("message","OK");
        return "redirect:/student/list";
    }
    @GetMapping("/student/edit/{id:[2]}")
    public String edit(@PathVariable(name = "id", required = false) int id, Model model) {
        Student student = iStudentService.edit(id);
        model.addAttribute("student", student);
        return "edit";
    }
}
