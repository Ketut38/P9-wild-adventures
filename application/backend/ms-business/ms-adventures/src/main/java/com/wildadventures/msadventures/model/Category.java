package com.wildadventures.msadventures.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="title")
    private String title;


    @Column(name = "description")
    private String description;


    @Column(name = "image")
    private String image;

//    @ManyToMany
//    @JoinTable( name = "category_adventure",
//            joinColumns = @JoinColumn( name = "category_id" ),
//            inverseJoinColumns = @JoinColumn( name = "adventure_id" ) )
//    private List<Adventure> adventures = new ArrayList<>();

    public Category(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Category() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public List<Adventure> getAdventures() {
//        return adventures;
//    }
//
//    public void setAdventures(List<Adventure> adventures) {
//        this.adventures = adventures;
//    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}