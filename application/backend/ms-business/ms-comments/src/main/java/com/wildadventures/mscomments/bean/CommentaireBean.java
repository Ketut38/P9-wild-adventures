package com.wildadventures.mscomments.bean;

import java.util.Date;

public class CommentaireBean {

    private Integer id;
    private String contents;
    private Date creationDate;
    private Integer adventureId;
    private Integer userId;

    public CommentaireBean() {
    }

    public Integer getId() {
        return id;
    }

    public CommentaireBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getContents() {
        return contents;
    }

    public CommentaireBean setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public CommentaireBean setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public CommentaireBean setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public CommentaireBean setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

}
