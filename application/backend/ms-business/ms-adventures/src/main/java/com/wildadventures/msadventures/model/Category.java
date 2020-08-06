package com.wildadventures.msadventures.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "category", targetEntity = CategoryAdventure.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<CategoryAdventure> categoryAdventures = new ArrayList<>(0);

    /*@OneToMany(fetch = FetchType.EAGER)
    private List<Adventure> adventures = new ArrayList<>();*/

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

    public List<CategoryAdventure> getCategoryAdventures() {
        return categoryAdventures;
    }

    public Category setCategoryAdventures(List<CategoryAdventure> categoryAdventures) {
        this.categoryAdventures = categoryAdventures;
        return this;
    }

    /* public List<Adventure> getAdventures() {
        return adventures;
    }

    public Category setAdventures(List<Adventure> adventures) {
        this.adventures = adventures;
        return this;
    }*/

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