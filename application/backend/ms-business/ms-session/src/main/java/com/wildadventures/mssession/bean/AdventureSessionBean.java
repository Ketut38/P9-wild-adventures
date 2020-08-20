package com.wildadventures.mssession.bean;

public class AdventureSessionBean {
    private Integer adventureId;
    private Integer sessionId;

    public AdventureSessionBean() {
    }

    public AdventureSessionBean(Integer adventureId, Integer sessionId) {
        this.adventureId = adventureId;
        this.sessionId = sessionId;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public AdventureSessionBean setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
        return this;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public AdventureSessionBean setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }
}
