package com.picture.repository;

import com.picture.model.Picture;

import java.util.List;

public interface IPictureRepository {
    List<Picture> findAll();
    boolean add(Picture picture);
    Picture findById(int id);
    boolean updateAwesome(int id);
    boolean updateGreat(int id);
}
