package com.wildadventures.mssession.controller;

import com.wildadventures.mssession.business.SessionService;
import com.wildadventures.mssession.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController{


    private SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }


    @RequestMapping(value = "/session/getAll/{aventureId}", method = RequestMethod.GET)
    public List<Session> getAllSessionsByAventureId(@PathVariable Integer adventureId){
        List<Session> sessions = sessionService.getAllSessionsByAventureId(adventureId);
        return sessions;
    }


    @GetMapping(value = "/session/{sessionId}")
    public Session findById(@PathVariable Integer sessionId) {
        Session session = sessionService.findById(sessionId);
        return session;
    }



}
