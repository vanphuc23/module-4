package com.example.picture_of_day_aop.service;

import com.example.picture_of_day_aop.exception.DuplicateBadWordsException;
import com.example.picture_of_day_aop.model.Picture;
import com.example.picture_of_day_aop.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository iPictureRepository;
    private String[] bad = {"chơi","xấu"};
    @Override
    public List<Picture> findAll() {
        return iPictureRepository.findAll();
    }

    @Override
    public boolean add(Picture picture) throws DuplicateBadWordsException {
        String[] arr = picture.getFeedBack().split(" ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < bad.length; j++) {
                if(arr[i].equalsIgnoreCase(bad[j])) {
                    throw new DuplicateBadWordsException("Chứa từ xấu");
                }
            }
        }
        iPictureRepository.save(picture);
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
