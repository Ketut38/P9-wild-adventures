package com.wildadventures.mssession.controller;

import com.wildadventures.mssession.business.SessionService;
import com.wildadventures.mssession.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/sessions")
public class SessionController{


    private SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }


    @GetMapping(value = "/{adventureId}/sessions")
    public List<Session> getAllSessionsByAdventureId(@PathVariable Integer adventureId){
        List<Session> sessions = sessionService.getAllSessionsByAdventureId(adventureId);
        return sessions;
    }


    @GetMapping(value = "/{sessionId}")
    public Session findById(@PathVariable Integer sessionId) {
        Session session = sessionService.findById(sessionId);
        return session;
    }


    // TODO : Enlever cette méthode de test
    @GetMapping()
    public List<Session> findAll() {
        List<Session> sessionList = new ArrayList<>();
        sessionList.add(new Session(LocalDate.now(), LocalDate.now()));
        sessionList.add(new Session(LocalDate.now(), LocalDate.now()));
        sessionList.add(new Session(LocalDate.now(), LocalDate.now()));

        return sessionList;
    }
}
