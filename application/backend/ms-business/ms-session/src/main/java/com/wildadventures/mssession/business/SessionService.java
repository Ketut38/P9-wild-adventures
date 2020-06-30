package com.wildadventures.mssession.business;

import com.wildadventures.mssession.consumer.SessionRepository;
import com.wildadventures.mssession.model.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SessionService {

    private SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessionsByAventureId(Integer aventureId) {
        return sessionRepository.findAllByAventureId(aventureId);
    }

    public Session findById(Integer sessionId) {
        return sessionRepository.findById(sessionId).get();
    }
}
