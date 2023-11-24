package com.example.casestudy.service.customer;

import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService{
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> listCustomerType() {
        return iCustomerTypeRepository.findAll();
    }
}
