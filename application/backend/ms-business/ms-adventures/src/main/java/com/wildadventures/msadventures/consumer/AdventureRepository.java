package com.wildadventures.msadventures.consumer;

import com.wildadventures.msadventures.bean.SessionBean;
import com.wildadventures.msadventures.model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Integer> {
}
