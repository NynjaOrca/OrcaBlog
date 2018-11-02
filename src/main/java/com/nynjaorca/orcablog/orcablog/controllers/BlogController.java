package com.nynjaorca.orcablog.orcablog.controllers;

import com.nynjaorca.orcablog.orcablog.entities.Animal;
import com.nynjaorca.orcablog.orcablog.entities.BlogPost;
import com.nynjaorca.orcablog.orcablog.exceptions.AnimalNotFoundException;
import com.nynjaorca.orcablog.orcablog.repositories.AnimalRepo;
import com.nynjaorca.orcablog.orcablog.repositories.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogRepo blogRepo;

    //ALL_POSTS
    @GetMapping
    public String findAll(Model model){
        model.addAttribute("posts", blogRepo.findAll());
        model.addAttribute("title", "Blog Posts");

        return "blog/all_posts";
    }

    //SINGLE_POST
    @GetMapping("/{id}")
    public String findOne(Model model, @PathVariable Long id){
        if(blogRepo.findById(id).isPresent()){
            BlogPost post = blogRepo.findById(id).get();
            model.addAttribute("post", post);
            return "blog/single_post";
        }else {
            return "blog/all_posts";
        }
    }

    //CREATE_POST
    @GetMapping("/create")
    public String createPost(Model model){
        model.addAttribute("title", "Create Post");
        model.addAttribute("post", new BlogPost());
        return "blog/creation_form";
    }

    @PostMapping("/create")
    public String createBlogPost(Model model, @ModelAttribute @Valid BlogPost blogPost, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Post");
            return "blog/creation_form";
        }

        blogRepo.save(blogPost);
        model.addAttribute("post", blogPost);
        return "blog/creation_success";
    }

    //REMOVE_POST
    @GetMapping("/delete")
    public String delete(Model model){
        model.addAttribute("posts", blogRepo.findAll());
        model.addAttribute("title", "Delete Posts");

        return "blog/delete_post";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam Long id){
        blogRepo.deleteById(id);
        model.addAttribute("posts", blogRepo.findAll());
        model.addAttribute("title", "Delete Posts");
        return "blog/delete_post";
    }

    //UPDATE_POST
    @GetMapping("/edit/{id}")
    public String editPost(Model model, @PathVariable Long id){
        if(blogRepo.findById(id).isPresent()){
            BlogPost post = blogRepo.findById(id).get();
            model.addAttribute("post", post);
            model.addAttribute("title", "Edit Post");
            return "blog/edit_post";
        }else {
            return "/blog/delete_post";
        }
    }

    @PostMapping("/edit/{id}")
    public String editPost(Model model,@PathVariable Long id, @ModelAttribute @Valid BlogPost post, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            if (blogRepo.findById(id).isPresent()) {
                BlogPost originalPost = blogRepo.findById(id).get();
                model.addAttribute("post", originalPost);
                model.addAttribute("title", "Edit Post");
                return "blog/edit_post";
            } else {
                return "/blog/delete_post";
            }
        } else {
            blogRepo.save(post);
            model.addAttribute("post", post);
            return "blog/edit_success";
        }
    }
}
