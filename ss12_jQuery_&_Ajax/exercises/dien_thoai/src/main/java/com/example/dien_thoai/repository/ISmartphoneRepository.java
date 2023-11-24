package com.example.dien_thoai.repository;


import com.example.dien_thoai.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
