package com.wildadventures.mssession.controller;

import com.wildadventures.mssession.bean.AdventureBean;
import com.wildadventures.mssession.business.SessionService;
import com.wildadventures.mssession.controller.exceptions.SessionNotFoundException;
import com.wildadventures.mssession.model.Sessions;
import com.wildadventures.mssession.proxy.MsAdventureProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sessions")
public class SessionController{

    @Autowired
    private MsAdventureProxy msAdventureProxy;

    private SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping()
    public List<Sessions> findAll() {
        return  sessionService.findAll();
    }

    @GetMapping(value = "/{adventureId}/sessions")
    public List<Sessions> getAllSessionsByAdventureId(@PathVariable Integer adventureId){
        List<Sessions> sessions = sessionService.getAllSessionsByAdventureId(adventureId);
        return sessions;
    }


    @GetMapping(value = "/{id}")
    public Sessions findById(@PathVariable Integer id) {
        Sessions sessions = sessionService.findById(id);
        if(sessions == null)
            throw new SessionNotFoundException("La sessions avec l'id " + id + " est INTROUVABLE");
        return sessions;
    }

    // TODO : Enlever le test plutard (Test Feign)
    @GetMapping(value = "/adventures")
    public List<AdventureBean> findAdventures() {
        return msAdventureProxy.getAdventures();
    }
}
