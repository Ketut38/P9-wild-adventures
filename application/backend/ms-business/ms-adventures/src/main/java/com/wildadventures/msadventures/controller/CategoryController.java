package com.wildadventures.msadventures.controller;

import com.wildadventures.msadventures.business.CategoryService;
import com.wildadventures.msadventures.controller.exceptions.CategoryNotFoundException;
import com.wildadventures.msadventures.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable Integer id) {

        Category category = categoryService.findById(id);
        if(category == null)
            throw new CategoryNotFoundException("La category avec l'id, " + id + " est INTROUVABLE");
        return category;
    }


    @GetMapping(value = "/category")
    public Category findByTitle(@PathVariable(value="title") String title){
        Category category = categoryService.findByTitle(title);
        return category;
    }


}
