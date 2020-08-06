package com.wildadventures.msadventures.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(CategoryAdventureKey.class)
@Table(name = "category_adventure")
public class CategoryAdventure implements Serializable {

    @JsonBackReference
    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;

    @Id @Column(name = "category_id")
    private Integer categoryId;

    @Id @Column(name = "adventure_id")
    private Integer adventureId;

    public CategoryAdventure() {
    }

    public Category getCategory() {
        return category;
    }

    public CategoryAdventure setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public CategoryAdventure setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public CategoryAdventure setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
        return this;
    }
}