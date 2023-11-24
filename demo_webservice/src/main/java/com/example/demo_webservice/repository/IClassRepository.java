package com.example.demo_webservice.repository;


import com.example.demo_webservice.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRepository extends JpaRepository<ClassRoom, Integer> {
}
