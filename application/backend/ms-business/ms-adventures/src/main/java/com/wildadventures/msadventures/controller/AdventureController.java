package com.wildadventures.msadventures.controller;

import java.util.List;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildadventures.msadventures.business.AdventureService;
import com.wildadventures.msadventures.business.CategoryService;
import com.wildadventures.msadventures.controller.exceptions.AdventureNotFoundException;
import com.wildadventures.msadventures.model.Adventure;
import com.wildadventures.msadventures.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdventureController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdventureService adventureService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/adventures")
    public List<Adventure> getAllAventures() {
        List<Adventure> adventures = new ArrayList<>(0);
        adventureService.getAllAventures().iterator().forEachRemaining(adventures::add);
        if (adventures.isEmpty()) {
            String message = "Il n'existe aucune aventures.";
            log.error(message);
            throw new AdventureNotFoundException(message);
        }

        log.info("Liste des aventures récupérée");
        return adventures;
    }

    // Récupère la liste des aventures d'une catégorie, s'il y en existe au moins une
    @GetMapping(value = "/category/{categoryId}")
    public List<Adventure> adventureList(@PathVariable Integer categoryId) {
        log.info("Tentative de récupération de la liste des aventures");

        List<Adventure> adventures = new ArrayList<>(0);

        log.info("Vérifier si la catégorie existe");
        Optional<Category> category = categoryService.findById(categoryId);
        category.ifPresent(cat ->
                cat.getCategoryAdventures().forEach(categoryAdventure ->
                        adventureService.findById(categoryAdventure.getAdventureId()).ifPresent(adventures::add)));
        if (adventures.isEmpty()) throw new AdventureNotFoundException("Il n'existe aucune aventures.");
        log.info("Récupération des aventures liées à la catégorie d'id "+categoryId);
        if (adventures.isEmpty()) {
            String message = "Il n'existe aucune aventures.";
            log.error(message);
            throw new AdventureNotFoundException(message);
        }

        return adventures;
    }

    // Récupère une aventure selon son ID
    @GetMapping(value = "/adventure/{id}")
    public Adventure getAdventure(@PathVariable Integer id) {
        log.info("Tentative de récupération de l'aventure");

        Optional<Adventure> adventure = adventureService.findById(id);
        if (!adventure.isPresent()) {
            String message = "Il n'existe aucune aventure pour id " + id;
            log.error(message);
            throw new AdventureNotFoundException(message);
        }

        log.info("Aventure récupérée");
        return adventure.get();
    }
    

}
