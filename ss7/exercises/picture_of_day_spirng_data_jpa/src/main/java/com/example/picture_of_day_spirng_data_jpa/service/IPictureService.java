package com.example.picture_of_day_spirng_data_jpa.service;

import com.example.picture_of_day_spirng_data_jpa.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPictureService {
    List<Picture> findAll();
    boolean add(Picture picture);
    Picture findById(int id);
    boolean updateAwesome(int id);
    boolean updateGreat(int id);
    Page<Picture> findAll(Pageable pageable);
}
