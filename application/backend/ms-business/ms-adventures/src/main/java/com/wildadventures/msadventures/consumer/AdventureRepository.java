package com.wildadventures.msadventures.consumer;

import com.wildadventures.msadventures.model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Integer> {
}
