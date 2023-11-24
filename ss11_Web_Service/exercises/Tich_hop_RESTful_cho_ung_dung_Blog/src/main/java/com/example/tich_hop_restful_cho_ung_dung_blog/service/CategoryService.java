package com.example.tich_hop_restful_cho_ung_dung_blog.service;


import com.example.tich_hop_restful_cho_ung_dung_blog.model.Category;
import com.example.tich_hop_restful_cho_ung_dung_blog.repository.ICategoryRepository;
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
