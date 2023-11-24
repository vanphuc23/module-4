package com.example.spring_security_example.repository;

import com.example.spring_security_example.model.AppUser;
import com.example.spring_security_example.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
