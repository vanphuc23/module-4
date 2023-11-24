package com.example.demo_webservice.service;


import com.example.demo_webservice.model.ClassRoom;
import com.example.demo_webservice.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository classRepository;

    @Override
    public List<ClassRoom> findAll() {
        return classRepository.findAll();
    }
}
