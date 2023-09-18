package com.student.service;

import com.student.model.Student;
import com.student.repository.IStudentRepository;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> display() {
        return iStudentRepository.display();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Student edit(int id) {
        return iStudentRepository.edit(id);
    }
}
