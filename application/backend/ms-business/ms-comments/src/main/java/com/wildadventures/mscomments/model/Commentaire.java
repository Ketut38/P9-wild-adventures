package com.wildadventures.mscomments.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "commentaire")
public class Commentaire implements Serializable {

    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "contents")
    private String contents;
    @Column(name = "created_at")
    private Date creationDate;
    @Column(name = "update_at")
    private Date updateDate;
    @Column(name = "adventure_id")
    private Integer adventureId;
    @Column(name = "user_id")
    private String userId;

    public Commentaire() {
    }

    public Commentaire(Integer id, String contents, Date creationDate, Date updateDate, int adventureId, String userId) {
        super();
        this.id = id;
        this.contents = contents;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.adventureId = adventureId;
        this.userId = userId;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContents() { return contents; }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", adventureId='" + adventureId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
