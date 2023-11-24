package com.example.picture_of_day_aop.service;


import com.example.picture_of_day_aop.exception.DuplicateBadWordsException;
import com.example.picture_of_day_aop.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPictureService {
    List<Picture> findAll();
    boolean add(Picture picture) throws DuplicateBadWordsException;
    Picture findById(int id);
    boolean updateAwesome(int id);
    boolean updateGreat(int id);
    Page<Picture> findAll(Pageable pageable);
}
