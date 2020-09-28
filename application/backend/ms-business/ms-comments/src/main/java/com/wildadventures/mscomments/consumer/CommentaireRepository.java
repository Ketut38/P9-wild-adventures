package com.wildadventures.mscomments.consumer;

import com.wildadventures.mscomments.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer>{

    List<Commentaire> findByAdventureId(Integer adventureId);

    List<Commentaire> findByUserId(String userId);

}
