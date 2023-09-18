package com.student.repository;

import com.student.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> display();
    void save(Student student);
    Student edit(int id);
}
