package com.example.spring_data_jpa.repository;


import com.example.spring_data_jpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    public Page<Student> findStudentByNameContaining(Pageable pageable,String searchName);
    @Query(value = "select * from Student where name like :searchName",nativeQuery = true)
    public List<Student> searchByClassName(@Param("searchName")String search);
}
