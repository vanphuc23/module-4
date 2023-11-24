package com.example.spring_data_jpa.service;

import com.example.spring_data_jpa.exception.DuplicateAdminCreate;
import com.example.spring_data_jpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add(Student student) throws DuplicateAdminCreate;
    Student findById(int id);
    Page<Student> findAll(Pageable pageable,String searchName);

}
