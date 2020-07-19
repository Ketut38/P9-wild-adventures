package com.wildadventures.mssession.controller;

import com.wildadventures.mssession.business.SessionService;
import com.wildadventures.mssession.controller.exceptions.SessionNotFoundException;
import com.wildadventures.mssession.model.Sessions;
import com.wildadventures.mssession.proxy.MsAdventureProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

    @GetMapping(value = "/{id}")
    public Sessions findById(@PathVariable Integer id) {
        Sessions sessions = sessionService.findById(id);
        if(sessions == null)
            throw new SessionNotFoundException("La sessions avec l'id " + id + " est INTROUVABLE");
        return sessions;
    }

    @GetMapping(value = "/{adventureId}/sessions")
    public List<Sessions> sessionList(@PathVariable Integer adventureId) {

        List<Sessions> sessions = new ArrayList<>(0);
        sessionService.findAllByAdventureId(adventureId).forEach(sessions::add);
        if (sessions.isEmpty()) {
            throw new SessionNotFoundException("Il n'existe aucune sessions pour cette aventure");
        }
        return sessions;
    }

}
