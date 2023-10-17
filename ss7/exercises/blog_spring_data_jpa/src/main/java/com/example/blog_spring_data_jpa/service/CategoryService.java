package com.example.blog_spring_data_jpa.service;

import com.example.blog_spring_data_jpa.model.Category;
import com.example.blog_spring_data_jpa.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> listCategory() {
        return iCategoryRepository.findAll();
    }
}
