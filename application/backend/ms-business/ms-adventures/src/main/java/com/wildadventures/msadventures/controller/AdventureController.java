package com.wildadventures.msadventures.controller;

import com.wildadventures.msadventures.business.AdventureService;
import com.wildadventures.msadventures.business.CategoryService;
import com.wildadventures.msadventures.consumer.AdventureRepository;
import com.wildadventures.msadventures.controller.exceptions.AdventureNotFoundException;
import com.wildadventures.msadventures.model.Adventure;
import com.wildadventures.msadventures.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/adventures")
public class AdventureController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdventureService adventureService;

    @Autowired
    private AdventureRepository adventureRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Adventure> getAllAventures(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Adventure> pageResult = adventureRepository.findAll(pageRequest);
        List<Adventure> adventures = pageResult
                .stream()
                .collect(toList());

        return new PageImpl<>(adventures, pageRequest, pageResult.getTotalElements());
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
