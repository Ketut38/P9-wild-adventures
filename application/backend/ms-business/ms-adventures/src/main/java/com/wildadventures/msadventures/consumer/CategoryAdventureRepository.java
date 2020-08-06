package com.wildadventures.msadventures.consumer;

import com.wildadventures.msadventures.model.CategoryAdventure;
import com.wildadventures.msadventures.model.CategoryAdventureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAdventureRepository extends JpaRepository<CategoryAdventure, CategoryAdventureKey> {
    Iterable<CategoryAdventure> findAllByAdventureId(Integer adventureId);
}