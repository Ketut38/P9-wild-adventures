package com.wildadventures.msadventures.controller;

import com.wildadventures.msadventures.business.AdventureService;
import com.wildadventures.msadventures.business.CategoryService;
import com.wildadventures.msadventures.controller.exceptions.AdventureNotFoundException;
import com.wildadventures.msadventures.model.Adventure;
import com.wildadventures.msadventures.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/adventures")
public class AdventureController {

    @Autowired
    private AdventureService adventureService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
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
