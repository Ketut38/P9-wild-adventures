package com.wildadventures.msadventures.model;

import java.io.Serializable;

public class CategoryAdventureKey implements Serializable {
    private Integer categoryId;
    private Integer adventureId;

    public CategoryAdventureKey() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public CategoryAdventureKey setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public CategoryAdventureKey setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
        return this;
    }
}