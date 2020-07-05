package com.wildadventures.msadventures.business;

import com.wildadventures.msadventures.consumer.AdventureRepository;
import com.wildadventures.msadventures.model.Adventure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdventureService {

    private AdventureRepository adventureRepository;

    @Autowired
    public AdventureService(AdventureRepository adventureRepository) {
        this.adventureRepository = adventureRepository;
    }

    public List<Adventure> getAllAventures(){
        return adventureRepository.findAll();
    }

    public Adventure findById(Integer id) {
        return adventureRepository.findById(id).get();
    }

    public List<Adventure> getAventuresByCategoryId(Integer categoryId){
        return adventureRepository.findAllByCategoryId(categoryId);
    }
}
