package com.formation.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.hellospring.CustomDataSource;
import com.formation.hellospring.models.PostBlog;
import com.formation.hellospring.repository.IRepoBlog;

@RestController
@RequestMapping("api/v1/blog")
public class PostBlogController {

    @Autowired
    IRepoBlog repoBlog;

    @Autowired
    CustomDataSource conflDeb;

    @GetMapping("posts")
    ResponseEntity<List<PostBlog>> getAll() {
        List<PostBlog> allBlog = repoBlog.findAll();
        return new ResponseEntity<>(allBlog, HttpStatus.OK);
    }

    @PostMapping("posts")
    ResponseEntity<PostBlog> createPost(@RequestBody PostBlog postBlog) {
        repoBlog.save(postBlog);
        return new ResponseEntity<>(postBlog, HttpStatus.CREATED);
    }
}

