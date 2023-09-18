package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class dictionaryServlet {
    @Autowired
    private IDictionaryService iDictionaryService;
    @GetMapping("dictionary/list")
    public String showList() {
        return "list";
    }
    @PostMapping("dictionary/list")
    public String list(@RequestParam String dictionary, Model model) {
        Map<String,String> map = iDictionaryService.search();
        String mess;
        model.addAttribute("dictionary", dictionary);
        for (Map.Entry<String, String> entry : map.entrySet()
                ) {
            if(entry.getKey().equalsIgnoreCase(dictionary)) {
                mess = entry.getValue();
                model.addAttribute("mess", mess);
                return "list";
            }
        }
        mess="Không tìm thấy";
        model.addAttribute("mess", mess);
        return "list";
    }
}
