package com.example.spring_data_jpa.service;

import com.example.spring_data_jpa.exception.DuplicateAdminCreate;
import com.example.spring_data_jpa.repository.IStudentRepository;
import com.example.spring_data_jpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    // DI interface
    @Autowired
    private IStudentRepository studentRepository ;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) throws DuplicateAdminCreate {
        if(student.getName().equals("Admin")) {
            throw new DuplicateAdminCreate("Không được đặt tên Admin");
        }
        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        studentRepository.findById(id).orElse(null);
        return null;
    }

    @Override
    public Page<Student> findAll(Pageable pageable,String searchName) {
        return studentRepository.findStudentByNameContaining(pageable,searchName);
    }

}
