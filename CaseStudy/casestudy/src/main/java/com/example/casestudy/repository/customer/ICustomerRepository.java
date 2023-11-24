package com.example.casestudy.repository.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findCustomerByCustomerNameContaining(Pageable pageable, String customerName);
}
