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

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Iterable<Category> findAllByIdIn(List<Integer> categoriesIdList){
        return categoryRepository.findAllByIdIn(categoriesIdList);
    }
}
