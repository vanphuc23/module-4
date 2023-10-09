package com.blog.repository;

import com.blog.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    void add(Blog blog);

    Blog read(int id);

    void update(Blog blog, int id);

    void delete(int id);
}
