package com.wildadventures.msadventures.model;

import org.hibernate.Session;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "adventure")
public class Adventure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="title")
    private String title;


    @Column(name = "description")
    private String description;


    @Column(name = "participant_count")
    private Integer participantCount;


    @Column(name = "location")
    private String location;


    @Column(name = "price")
    private Integer price;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "adventure", targetEntity = AdventureSession.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<AdventureSession> adventureSessions = new ArrayList<>(0);

    public Adventure(String title, String description, Integer participantCount, String location, Integer price, String image) {
        this.title = title;
        this.description = description;
        this.participantCount = participantCount;
        this.location = location;
        this.price = price;
        this.image = image;
    }

    public Adventure() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(Integer participantCount) {
        this.participantCount = participantCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<AdventureSession> getCategoryAdventures() {
        return adventureSessions;
    }

    public Adventure setCategoryAdventures(List<AdventureSession> categoryAdventures) {
        this.adventureSessions = categoryAdventures;
        return this;
    }

    @Override
    public String toString() {
        return "Aventure{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", nbparticipant=" + participantCount +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
