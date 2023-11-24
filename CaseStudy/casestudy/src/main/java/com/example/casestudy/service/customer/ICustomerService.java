package com.example.casestudy.service.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> listCustomer();
    void addCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    Customer findCustomerById(Long id);
    Page<Customer> findByCustomerName(Pageable pageable, String customerName);
    Page<Customer> findAll(Pageable pageable);
}
