package com.formation.hellospring.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name="postblog")
@Table(name="postblog")
public class PostBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;
    private Date dtCreation;
    private String author;

    public PostBlog() {
        id=0L;
        title="";
        content="";
        dtCreation= new Date();
        author="";
    }

    public PostBlog(Long id, String title, String content, Date dtCreation, String author) {
        this.id=id;
        this.title=title;
        this.content=content;
        this.dtCreation= dtCreation;
        this.author=author;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDtCreation() {
        return dtCreation;
    }

    public void setDtCreation(Date dtCreation) {
        this.dtCreation = dtCreation;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "PostBlog{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", dtCreation='" + dtCreation + '\'' +
        ",author='" + author + '\'' +
        '}';
    }
}
