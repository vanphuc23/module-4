package com.example.casestudy.controller;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.service.contract.IContractService;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IFacilityService iFacilityService;
    @GetMapping("")
    public String showContractList(Model model) {
        model.addAttribute("contracts",iContractService.contractList());
        return "contract/contractList";
    }
    @GetMapping("/create")
    public String showCreateContract(Model model) {
        model.addAttribute("contract",new Contract());
        model.addAttribute("customers",iCustomerService.listCustomer());
        model.addAttribute("facilitys",iFacilityService.listFacility());
        return "contract/createContract";
    }
}
