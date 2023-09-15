package com.student.controller;

import com.student.model.Student;
import com.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentServlet {
    @Autowired
    private IStudentService iStudentService;

    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public String showList(Model model) {
        List<Student> list = iStudentService.display();
        model.addAttribute("list", list);
        return "list";
    }
}
