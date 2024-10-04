package com.formation.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.hellospring.models.PostBlog;

public interface IRepoBlog extends JpaRepository<PostBlog, Long> {

}
