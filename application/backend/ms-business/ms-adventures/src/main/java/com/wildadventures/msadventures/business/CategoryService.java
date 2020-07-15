package com.wildadventures.msadventures.business;


import com.wildadventures.msadventures.consumer.CategoryRepository;
import com.wildadventures.msadventures.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            return category.get();
        }
        return null;
    }

    public Category findByTitle(String title){
        return categoryRepository.getByTitle(title);
    }

    public Iterable<Category> findAllByIdIn(List<Integer> categoriesIdList){
        return categoryRepository.findAllByIdIn(categoriesIdList);
    }
}
