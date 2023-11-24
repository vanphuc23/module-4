package com.example.blog_spring_data_jpa.controller;

import com.example.blog_spring_data_jpa.model.Blog;
import com.example.blog_spring_data_jpa.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class RestControllerBlog {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam(defaultValue = "",required = false) String post) {
        List<Blog> list = iBlogService.searchPost(post);
        if(list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/pages")
    public ResponseEntity<Page<Blog>> showListBlog(@RequestParam(defaultValue = "0",required = false) int page) {
        Pageable pageable = PageRequest.of(page,20);
        Page<Blog> blogPage = iBlogService.findAll(pageable);
        if(blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }
}
