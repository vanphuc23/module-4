package com.student.service;

import com.student.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> display();
    void save(Student student);
    Student edit(int id);
}
