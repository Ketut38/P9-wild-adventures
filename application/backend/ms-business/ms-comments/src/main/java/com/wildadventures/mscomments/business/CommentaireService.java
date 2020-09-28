package com.wildadventures.mscomments.business;

import com.wildadventures.mscomments.consumer.CommentaireRepository;
import com.wildadventures.mscomments.model.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    private CommentaireRepository commentaireRepository;

    @Autowired
    public void CommentsService(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    public List<Commentaire> getAdventureComments(int adventureId){
        return commentaireRepository.findByAdventureId(adventureId);
    }

    public Commentaire addComment(Commentaire commentaire) {
        // Creation de l'instance à créer
        Commentaire newComment = new Commentaire();
        newComment.setContents(commentaire.getContents());
        newComment.setCreationDate(new Date());
        newComment.setAdventureId(commentaire.getAdventureId());
        newComment.setUserId(commentaire.getUserId());
        // Insertion dans la BDD

        return commentaireRepository.save(newComment);
    }

    public Commentaire updateCommentaire(Commentaire commentaire, int commentId){

        Optional<Commentaire> commentToUpdate = this.findById(commentId);
        Commentaire commentaire1 = commentToUpdate.get();
        commentaire1.setUpdateDate(new Date());
        commentaire1.setContents(commentaire.getContents());
     //   commentaire1.setCreationDate(commentaire.getCreationDate());
        commentaire1.setAdventureId(commentaire.getAdventureId());
        commentaire1.setUserId(commentaire.getUserId());

        return commentaireRepository.save(commentaire1);
    }

    public  List<Commentaire> findByUser(String userId){
        List<Commentaire> userComments = commentaireRepository.findByUserId(userId);
        return userComments;
    }

    public Optional<Commentaire> findById(Integer id){
        Optional<Commentaire> commentaire = commentaireRepository.findById(id);
        return commentaire;
    }

    public void deleteCommentaireById(Integer commentId){commentaireRepository.deleteById(commentId);}
}
