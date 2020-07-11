package com.wildadventures.msadventures.controller;

import com.wildadventures.msadventures.business.AdventureService;
import com.wildadventures.msadventures.controller.exceptions.AdventureNotFoundException;
import com.wildadventures.msadventures.model.Adventure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/adventures")
public class AdventureController {

    private AdventureService adventureService;

    @Autowired
    public AdventureController (AdventureService adventureService){
        this.adventureService = adventureService;
    }


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
