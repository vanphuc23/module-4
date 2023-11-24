package com.example.casestudy.service.customer;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> listCustomer() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void addCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        iCustomerRepository.delete(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findByCustomerName(Pageable pageable, String customerName) {
        return iCustomerRepository.findCustomerByCustomerNameContaining(pageable,customerName);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }
}
