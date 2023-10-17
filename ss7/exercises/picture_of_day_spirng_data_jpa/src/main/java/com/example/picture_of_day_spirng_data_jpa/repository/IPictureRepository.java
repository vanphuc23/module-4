package com.example.picture_of_day_spirng_data_jpa.repository;


import com.example.picture_of_day_spirng_data_jpa.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPictureRepository extends JpaRepository<Picture,Integer> {

}
