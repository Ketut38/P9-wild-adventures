package com.wildadventures.msadventures.business;


import com.wildadventures.msadventures.consumer.CategoryRepository;
import com.wildadventures.msadventures.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    public Category findByTitle(String title){
        return categoryRepository.getByTitle(title);
    }
}
