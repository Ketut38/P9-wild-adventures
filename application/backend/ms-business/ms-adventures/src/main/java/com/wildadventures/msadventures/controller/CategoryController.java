package com.wildadventures.msadventures.controller;

import com.wildadventures.msadventures.business.CategoryService;
import com.wildadventures.msadventures.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
        return categoryService.findById(id);
    }


    @GetMapping(value = "/category")
    public Category findByTitle(@PathVariable(value="title") String title){
        return categoryService.findByTitle(title);
    }


}
