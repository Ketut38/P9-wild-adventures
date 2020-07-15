package com.wildadventures.mssession.business;

import com.wildadventures.mssession.consumer.SessionRepository;
import com.wildadventures.mssession.model.Sessions;
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

    public List<Sessions> findAll() {
        return sessionRepository.findAll();
    }

    public Iterable<Sessions> findAllByAdventureId(Integer adventureId) {
        return sessionRepository.findAllByAdventureId(adventureId);
    }

    public Iterable<Sessions> findAllByIdIn(List<Integer> sessionsIdList){
        return sessionRepository.findAllByIdIn(sessionsIdList);
    }

    public Sessions findById(Integer sessionId) {
        return sessionRepository.getOne(sessionId);
    }
}
