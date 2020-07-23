package com.wildadventures.mssession.bean;

import com.wildadventures.mssession.model.Sessions;

import java.util.ArrayList;
import java.util.List;

public class AdventureBean {

    private Integer id;
    private String title;
    private String description;
    private Integer participantCount;
    private String location;
    private Integer price;
    private String image;
    private List<Sessions> sessions = new ArrayList<>(0);

    public AdventureBean() {
    }

    public Integer getId() {
        return id;
    }

    public AdventureBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AdventureBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AdventureBean setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getParticipantCount() {
        return participantCount;
    }

    public AdventureBean setParticipantCount(Integer participantCount) {
        this.participantCount = participantCount;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public AdventureBean setLocation(String location) {
        this.location = location;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public AdventureBean setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getImage() {
        return image;
    }

    public AdventureBean setImage(String image) {
        this.image = image;
        return this;
    }

    public List<Sessions> getSessions() {
        return sessions;
    }

    public AdventureBean setSessions(List<Sessions> sessions) {
        this.sessions = sessions;
        return this;
    }
}
