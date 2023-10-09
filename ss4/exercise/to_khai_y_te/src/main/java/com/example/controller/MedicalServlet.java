package com.example.controller;

import com.example.model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medical")
public class MedicalServlet {
    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("medical", new Medical());
        model.addAttribute("listYear", new String[]{"2010", "2005", "2000", "1995", "1990"});
        model.addAttribute("listGender", new String[]{"Nam", "Nữ"});
        model.addAttribute("listCountry", new String[]{"Việt Nam", "Trung Quốc", "Hàn Quốc"});
        model.addAttribute("listVihacle", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác(Ghi rõ)"});
        model.addAttribute("listCity", new String[]{"Đà Nẵng", "Hà Nội", "Hồ Chí Minh"});
        model.addAttribute("listDistrict", new String[]{"Liên Chiểu", "Thanh Khê", "Hà Đông"});
        model.addAttribute("listWard", new String[]{"Hòa Khánh Bắc", "Hòa Khánh Nam", "Phú Đông"});
        return "list";
    }
}
