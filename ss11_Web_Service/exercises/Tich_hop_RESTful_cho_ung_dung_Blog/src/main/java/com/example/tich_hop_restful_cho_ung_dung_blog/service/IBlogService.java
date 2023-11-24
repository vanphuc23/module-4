package com.example.tich_hop_restful_cho_ung_dung_blog.service;


import com.example.tich_hop_restful_cho_ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable, String searchTitle);
    List<Blog> listBlog();

    void add(Blog blog);

    Blog read(int id);

    void update(Blog blog, int id);

    void delete(int id);
    Page<Blog> showListCategoryOfBlog(Pageable pageable,int categoryOfBlog);
    List<Blog> findCategory(int id);
}
