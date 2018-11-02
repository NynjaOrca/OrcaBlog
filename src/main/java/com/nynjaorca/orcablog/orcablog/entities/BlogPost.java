package com.nynjaorca.orcablog.orcablog.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Size(min = 1, max = 100, message = "(Size must be between 1 and 100)")
    @Column(nullable = false, unique = true, length=100)
    public String post_title;

    @Size(min = 1, max = 5000, message = "(Size must be between 1 and 5000)")
    @Column(nullable = false, length = 5000)
    public String post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
