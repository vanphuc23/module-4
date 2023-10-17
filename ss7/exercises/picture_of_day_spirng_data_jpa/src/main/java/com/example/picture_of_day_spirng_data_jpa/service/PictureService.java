package com.example.picture_of_day_spirng_data_jpa.service;

import com.example.picture_of_day_spirng_data_jpa.model.Picture;
import com.example.picture_of_day_spirng_data_jpa.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository iPictureRepository;

    @Override
    public List<Picture> findAll() {
        return iPictureRepository.findAll();
    }

    @Override
    public boolean add(Picture picture) {
        try {
            iPictureRepository.save(picture);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Picture findById(int id) {
        return iPictureRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateAwesome(int id) {
        try {
            Picture picture = findById(id);
            picture.setAwesome(picture.getAwesome() + 1);
            iPictureRepository.save(picture);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGreat(int id) {
        try {
            Picture picture = findById(id);
            picture.setGreat(picture.getGreat() + 1);
            iPictureRepository.save(picture);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Page<Picture> findAll(Pageable pageable) {
        return iPictureRepository.findAll(pageable);
    }
}
