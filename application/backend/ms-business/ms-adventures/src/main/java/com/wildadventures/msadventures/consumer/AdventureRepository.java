package com.wildadventures.msadventures.consumer;

import com.wildadventures.msadventures.model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Integer> {
}
