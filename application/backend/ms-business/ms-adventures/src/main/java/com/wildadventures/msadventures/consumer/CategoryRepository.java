package com.wildadventures.msadventures.consumer;

import com.wildadventures.msadventures.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category getByTitle(String title);
}