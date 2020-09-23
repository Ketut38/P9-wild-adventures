package com.wildadventures.mssession.controller;

import com.wildadventures.mssession.bean.AdventureBean;
import com.wildadventures.mssession.business.SessionService;
import com.wildadventures.mssession.controller.exceptions.SessionNotFoundException;
import com.wildadventures.mssession.model.Sessions;
import com.wildadventures.mssession.proxy.MsAdventureProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/sessions")
public class SessionController{

    private Logger log = LoggerFactory.getLogger(this.getClass());

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


    // Récupère la liste des sessions d'une aventure, s'il y en existe au moins une.
    @GetMapping(value = "/adventure/{adventureId}")
    public List<Sessions> sessionList(@PathVariable Integer adventureId) {
        log.info("Tentative de récupération de la liste des sessions");

        List<Sessions> sessions = new ArrayList<>(0);
        sessionService.findAllByAdventureId(adventureId).forEach(sessions::add);
        if (sessions.isEmpty()) {
            throw new SessionNotFoundException("Il n'existe aucune sessions pour cette aventure");
        }
        return sessions;
    }

    @GetMapping(value= "/single/{sessionId}")
    public ResponseEntity<Sessions> getSessionById(@PathVariable Integer sessionId){
        log.info("Tentative de récupération de la session");

        if(sessionId == null){
            String message = "Aucun id de session transmis";
            log.error(message);
            throw new SessionNotFoundException(message);
        }
        Optional<Sessions> session = sessionService.findById(sessionId);
        if(!session.isPresent()){
            String message = "Aucune session de trouver pour cet id : " + sessionId;
            log.error(message);
            throw new SessionNotFoundException(message);
        }

        log.info("Session récupérée");
        return new ResponseEntity<>(session.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/{sessionId}/adventure")
    public ResponseEntity<AdventureBean> getAdventureBySessionId(@PathVariable Integer sessionId){
        Optional<AdventureBean> adventure = msAdventureProxy.getOneAdventure(sessionId);
        if(!adventure.isPresent()){
            String message = "Aucune aventure de trouver pour cet session id : " + sessionId;
            log.error(message);
            throw new SessionNotFoundException(message);
        }

        log.info("Aventure récupérée");
        return new ResponseEntity<>(adventure.get(), HttpStatus.OK);
    }


}
