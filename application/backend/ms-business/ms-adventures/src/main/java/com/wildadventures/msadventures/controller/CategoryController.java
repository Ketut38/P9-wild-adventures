package com.wildadventures.msadventures.controller;

import com.wildadventures.msadventures.business.CategoryService;
import com.wildadventures.msadventures.consumer.CategoryAdventureRepository;
import com.wildadventures.msadventures.controller.exceptions.CategoryNotFoundException;
import com.wildadventures.msadventures.model.Category;
import com.wildadventures.msadventures.model.CategoryAdventure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/categories")
public class CategoryController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryAdventureRepository categoryAdventureRepository;

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Récupère la liste des catégories, s'il y en existe au moins une.
     * @return
     */
    @GetMapping()
    public List<Category> categoryList() {
        log.info("Tentative de récupération de la liste des catégories");

        List<Category> categories = new ArrayList<>(0);
        categoryService.getAllCategories().iterator().forEachRemaining(categories::add);
        if (categories.isEmpty()) {
            String message = "Il n'existe aucune catégories.";
            log.error(message);
            throw new CategoryNotFoundException(message);
        }

        log.info("Liste des catégories récupérée");
        return categories;
    }

    /**
     * Récupère une catégorie selon son ID
     * @param id
     * @return
     */
    @GetMapping(value = "category/{id}")
    public Optional<Category> getCategory(@PathVariable Integer id) {
        log.info("Tentative de récupération de la catégorie");

        Optional<Category> category = categoryService.findById(id);
        if (!category.isPresent()) {
            String message = "Il n'existe aucune catégorie pour id " + id + ".";
            log.error(message);
            throw new CategoryNotFoundException(message);
        }

        log.info("Catégorie récupérée");
        return category;
    }


    /**
     * Récupère la liste des catégories d'une aventure, s'il y en existe au moins une.
     * @param adventureId
     * @return
     */
    @GetMapping(value = "/adventure/{adventureId}/categories")
    public List<Category> categoryListByAdventure(@PathVariable Integer adventureId) {
        log.info("Tentative de récupération de la liste des catégories");

        List<Category> categories = new ArrayList<>(0);
        List<CategoryAdventure> categoriesAdventure = new ArrayList<>(0);
        List <Integer> categoriesId = new ArrayList<>(0);

        categoryAdventureRepository.findAllByAdventureId(adventureId).iterator().forEachRemaining(categoriesAdventure::add);
        if (categoriesAdventure.isEmpty()) {
            String message = "Il n'existe aucune catégories.";
            log.error(message);
            throw new CategoryNotFoundException(message);
        }
        categoriesAdventure.iterator().forEachRemaining(categoryAdventure -> categoriesId.add(categoryAdventure.getCategoryId()));
        categoryService.findAllByIdIn(categoriesId).iterator().forEachRemaining(categories::add);

        log.info("Récupération des catégories liées à l'aventure d'ID " + adventureId);
        return categories;
    }


}
