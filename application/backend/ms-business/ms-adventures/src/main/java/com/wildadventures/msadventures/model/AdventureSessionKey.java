package com.wildadventures.msadventures.model;

import java.io.Serializable;

public class AdventureSessionKey implements Serializable{
    private Integer adventureId;
    private Integer sessionId;

    public AdventureSessionKey() {
    }

    public AdventureSessionKey(Integer adventureId, Integer sessionId) {
        this.adventureId = adventureId;
        this.sessionId = sessionId;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public AdventureSessionKey setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
        return this;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public AdventureSessionKey setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }
}
