package com.wildadventures.mssession.controller;

import com.wildadventures.mssession.business.SessionService;
import com.wildadventures.mssession.controller.exceptions.SessionNotFoundException;
import com.wildadventures.mssession.model.Sessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sessions")
public class SessionController{


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


    @GetMapping(value = "/{sessionId}")
    public Sessions findById(@PathVariable Integer sessionId) {
        Sessions sessions = sessionService.findById(sessionId);
        if(sessions == null)
            throw new SessionNotFoundException("La sessions avec l'id " + sessionId + " est INTROUVABLE");
        return sessions;
    }
}
