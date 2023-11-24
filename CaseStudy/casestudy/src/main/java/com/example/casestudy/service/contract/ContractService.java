package com.example.casestudy.service.contract;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService{
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<Contract> contractList() {
        return iContractRepository.findAll();
    }
}
