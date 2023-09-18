package com.student.repository;

import com.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> list = new ArrayList<>();
    static {
        list.add(new Student(1,"A"));
        list.add(new Student(2,"B"));
    }
    @Override
    public List<Student> display() {
        return list;
    }

    @Override
    public void save(Student student) {
        list.add(student);
    }

    @Override
    public Student edit(int id) {
        for (Student student: list
             ) {
            if(student.getId() == id) {
                return student;
            }
        }
        return null;
    }

}
