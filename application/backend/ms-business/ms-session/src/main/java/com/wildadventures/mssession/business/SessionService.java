package com.wildadventures.mssession.business;

import com.wildadventures.mssession.consumer.SessionRepository;
import com.wildadventures.mssession.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public List<Session> getAllSessionsByAdventureId(Integer adventureId) {
        return sessionRepository.findAllByAdventureId(adventureId);
    }

    public Session findById(Integer sessionId) {
        return sessionRepository.getOne(sessionId);
    }
}
