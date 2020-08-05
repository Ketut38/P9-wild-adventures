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

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdventureController {

    @Autowired
    private AdventureService adventureService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/adventures")
    public List<Adventure> getAllAventures() {
        return adventureService.getAllAventures();
    }

    @GetMapping(value = "/adventure/{id}")
    public Adventure findById(@PathVariable Integer id) {
        Adventure adventure =  adventureService.findById(id);
        if(adventure==null)
            throw new AdventureNotFoundException("L'aventure avec l'id, " + id + " est INTROUVABLE");
        return adventure;
    }
    

}
