package com.example.blog_spring_data_jpa.service;

import com.example.blog_spring_data_jpa.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> listCategory();
}