package com.wildadventures.msadventures.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AdventureSessionKey.class)
@Table(name = "adventure_session", schema = "waadventure")
public class AdventureSession implements Serializable {

    @ManyToOne(targetEntity = Adventure.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "adventure_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Adventure adventure;

    @Id @Column(name = "adventure_id")
    private Integer adventureId;

    @Id @Column(name = "session_id")
    private Integer sessionId;

    public AdventureSession() {
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public AdventureSession setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
        return this;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public AdventureSession setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }
}

