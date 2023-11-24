package com.example.tich_hop_restful_cho_ung_dung_blog.service;


import com.example.tich_hop_restful_cho_ung_dung_blog.model.Blog;
import com.example.tich_hop_restful_cho_ung_dung_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable, String searchTitle) {
        return iBlogRepository.findByTitleContaining(pageable,searchTitle);
    }

    @Override
    public List<Blog> listBlog() {
        return iBlogRepository.findAll();
    }

    @Override
    public void add(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog read(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog, int id) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> showListCategoryOfBlog(Pageable pageable, int categoryOfBlog) {
        return iBlogRepository.showListCategoryId(pageable,categoryOfBlog);
    }

    @Override
    public List<Blog> findCategory(int id) {
        return iBlogRepository.showListBlog(id);
    }
}
