package com.example.demo_webservice.service;



import com.example.demo_webservice.model.ClassRoom;

import java.util.List;

public interface IClassService {
    List<ClassRoom> findAll();
}
