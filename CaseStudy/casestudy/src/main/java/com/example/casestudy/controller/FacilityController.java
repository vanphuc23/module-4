package com.example.casestudy.controller;

import com.example.casestudy.model.facility.Facility;
import com.example.casestudy.model.facility.FacilityType;
import com.example.casestudy.service.facility.IFacilityService;
import com.example.casestudy.service.facility.IFacilityTypeService;
import com.example.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facilities")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @GetMapping("")
    public String showFacilityList(Model model) {
        model.addAttribute("facilities", iFacilityService.listFacility());
        model.addAttribute("facilityTypes",iFacilityTypeService.facilityTypeList());
        return "facility/facilityList";
    }
    @GetMapping("/facilityType/create/{id}")
    public String showCreateFacility(@PathVariable Long id, Model model) {
        FacilityType facilityType = iFacilityTypeService.findById(id);
        Facility facility = new Facility();
        model.addAttribute("rentTypes",iRentTypeService.rentTypeList());
        facility.setFacilityType(facilityType);
        if(facilityType.getFacilityTypeName().equalsIgnoreCase("Villa")) {
            model.addAttribute("facilityType",facilityType);
            model.addAttribute("facility",facility);
            return "facility/villa/createVilla";
        }else if(facilityType.getFacilityTypeName().equalsIgnoreCase("House")) {
            model.addAttribute("facilityType",facilityType);
            model.addAttribute("facility",facility);
            return "facility/house/createHouse";
        }else if(facilityType.getFacilityTypeName().equalsIgnoreCase("Room")) {
            model.addAttribute("facilityType",facilityType);
            model.addAttribute("facility",facility);
            return "facility/room/createRoom";
        }
        return "";
    }
    @PostMapping("/facilityType/create")
    public String createFacility(@ModelAttribute Facility facility, Model model, RedirectAttributes redirectAttributes) {
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Create success");
        return "redirect:/facilities";
    }
    @GetMapping("/edit/{id}")
    public String showEditFacility(@PathVariable Long id,Model model) {
        Facility facility = iFacilityService.findFacilityByFacilityId(id);
        model.addAttribute("facilityType",facility.getFacilityType().getFacilityTypeName());
        model.addAttribute("facility",facility);
        model.addAttribute("rentTypes",iRentTypeService.rentTypeList());
        if(facility.getFacilityType().getFacilityTypeName().equalsIgnoreCase("Villa")) {
            return "facility/villa/editVilla";
        } else if(facility.getFacilityType().getFacilityTypeName().equalsIgnoreCase("House")) {
            return "facility/house/editHouse";
        } else if(facility.getFacilityType().getFacilityTypeName().equalsIgnoreCase("Room")) {
            return "facility/room/editRoom";
        }
        return "";
    }
    @PostMapping("/edit")
    public String editFacility(@ModelAttribute Facility facility,RedirectAttributes redirectAttributes) {
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Edit Success");
        return "redirect:/facilities";
    }
    @PostMapping("/delete")
    public String deleteFacility(@RequestParam Long facilityId,RedirectAttributes redirectAttributes) {
        Facility facility = iFacilityService.findFacilityByFacilityId(facilityId);
        iFacilityService.deleteFacility(facility);
        redirectAttributes.addFlashAttribute("mess", "Delete Success");
        return "redirect:/facilities";
    }
}
