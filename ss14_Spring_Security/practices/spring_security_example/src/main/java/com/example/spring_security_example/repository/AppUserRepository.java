package com.example.spring_security_example.repository;

import com.example.spring_security_example.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String username);
}
