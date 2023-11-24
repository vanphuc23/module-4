package com.example.picture_of_day_aop.repository;



import com.example.picture_of_day_aop.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPictureRepository extends JpaRepository<Picture,Integer> {

}
