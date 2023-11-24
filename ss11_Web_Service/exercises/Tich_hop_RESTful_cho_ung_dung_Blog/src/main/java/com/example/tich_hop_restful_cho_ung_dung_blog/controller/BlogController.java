package com.example.tich_hop_restful_cho_ung_dung_blog.controller;


import com.example.tich_hop_restful_cho_ung_dung_blog.model.Blog;
import com.example.tich_hop_restful_cho_ung_dung_blog.model.Category;
import com.example.tich_hop_restful_cho_ung_dung_blog.service.IBlogService;
import com.example.tich_hop_restful_cho_ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> showListBlog() {
        List<Blog> blogList = iBlogService.listBlog();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> showCategory() {
        List<Category> listCategory = iCategoryService.listCategory();
        if(listCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listCategory, HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> showListBlogofCategoryId(@PathVariable int id) {
        List<Blog> blogList = iBlogService.findCategory(id);
        if(blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> readBlog(@PathVariable int id) {
        Blog blog = iBlogService.read(id);
        if(blog == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
