package com.example.blog_spring_data_jpa.service;

import com.example.blog_spring_data_jpa.model.Blog;
import com.example.blog_spring_data_jpa.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sun.java2d.loops.Blit;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable,String searchTitle);

    void add(Blog blog);

    Blog read(int id);

    void update(Blog blog, int id);

    void delete(int id);
    Page<Blog> showListCategoryOfBlog(Pageable pageable,int categoryOfBlog);
}
