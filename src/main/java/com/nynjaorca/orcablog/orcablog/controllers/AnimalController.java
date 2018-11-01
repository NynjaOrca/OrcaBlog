package com.nynjaorca.orcablog.orcablog.controllers;

import com.nynjaorca.orcablog.orcablog.entities.Animal;
import com.nynjaorca.orcablog.orcablog.exceptions.AnimalNotFoundException;
import com.nynjaorca.orcablog.orcablog.repositories.AnimalRepo;
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
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalRepo animRepo;

    //ALL_ANIMALS
    @GetMapping
    public String findAll(Model model){
        model.addAttribute("animals", animRepo.findAll());
        model.addAttribute("title", "Animals");

        return "animal/all_animals";
    }

    //SINGLE_ANIMAL
    @GetMapping("/{id}")
    public String findOne(Model model, @PathVariable Long id){
        if(animRepo.findById(id).isPresent()){
            Animal animal = animRepo.findById(id).get();
            model.addAttribute("animal", animal);
            return "animal/single_animal";
        }else {
            return "/animal/all_animals";
        }
    }

    //CREATE_ANIMAL
    @GetMapping("/create")
    public String createAnimal(Model model){
        model.addAttribute("title", "Create Animal");
        model.addAttribute(new Animal());
        return "animal/creation_form";
    }

    @PostMapping("/create")
    public String createAnimal(Model model, @ModelAttribute @Valid Animal animal, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Animal");
            return "animal/creation_form";
        }

        animRepo.save(animal);
        model.addAttribute("animal", animal);
        return "animal/creation_success";
    }

    //REMOVE_ANIMAL
    @GetMapping("/delete")
    public String AnimalDeletionList(Model model){
        model.addAttribute("animals", animRepo.findAll());
        model.addAttribute("title", "Remove Animals");

        return "animal/delete_animal";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam Long id){
        animRepo.deleteById(id);
        model.addAttribute("animals", animRepo.findAll());
        model.addAttribute("title", "Remove Animals");
        return "animal/delete_animal";
    }

    //UPDATE_ANIMAL
    @GetMapping("/edit/{id}")
    public String editAnimal(Model model, @PathVariable Long id){
        if(animRepo.findById(id).isPresent()){
            Animal animal = animRepo.findById(id).get();
            model.addAttribute("animal", animal);
            model.addAttribute("title", "Edit Animal");
            return "animal/edit_animal";
        }else {
            return "/animal/delete_animal";
        }
    }

    @PostMapping("/edit/{id}")
    public String editAnimal(Model model,@PathVariable Long id, @ModelAttribute @Valid Animal animal, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            if (animRepo.findById(id).isPresent()) {
                Animal originalAnimal = animRepo.findById(id).get();
                model.addAttribute("animal", originalAnimal);
                model.addAttribute("title", "Edit Animal");
                return "animal/edit_animal";
            } else {
                return "/animal/delete_animal";
            }
        } else {
            animRepo.save(animal);
            model.addAttribute("animal", animal);
            return "animal/edit_success";
        }
    }
}
