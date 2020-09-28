package com.wildadventures.mscomments.controller;

import com.wildadventures.mscomments.business.CommentaireService;
import com.wildadventures.mscomments.consumer.CommentaireRepository;
import com.wildadventures.mscomments.controller.exceptions.CommentaireCreateException;
import com.wildadventures.mscomments.model.Commentaire;
import com.wildadventures.mscomments.controller.exceptions.CommentaireNotFoundException;
import com.wildadventures.mscomments.proxy.MsCommentsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/commentaire")
public class CommentaireController {
    Logger log = LoggerFactory.getLogger(this.getClass());

  /*  @Autowired
    private MsCommentsProxy msCommentsProxy;*/

    @Autowired
    private CommentaireRepository commentaireRepository;

    private CommentaireService commentaireService;

    @Autowired
    public CommentaireController(CommentaireService commentaireService){ this.commentaireService = commentaireService; }

    // recuperer la liste des commentaires d'une aventure = getAdventureComments

    @GetMapping(value = "/adventure/{adventureId}")
    public List<Commentaire> getAdventureComments(@PathVariable int adventureId){
        log.info("Début méthode : getAdventureComments()");
        List<Commentaire> commentaires = commentaireService.getAdventureComments(adventureId);
        if(commentaires == null || commentaires.isEmpty()){
            throw new CommentaireNotFoundException("Aucun commentaire n'est renseigné sur cette aventure");
        }
        return commentaires;
    }

    // ajouter un commentaire = addComment
    @PostMapping(value = "/add")
    public ResponseEntity<Commentaire> createComment(@RequestBody Commentaire commentaire){
        log.info("Début méthode : addComment()");
        if(commentaire == null) {
            log.error("Le commentaire est nul");
            throw new CommentaireCreateException("Le commentaire est nul");
        }
        //Vérification du contenu
        if(commentaire.getContents()== null || commentaire.getContents().isEmpty()) {
            log.error("Le commentaire ne possède aucun texte");
            throw new CommentaireCreateException(("Le commentaire ne possède aucun texte"));
        }
        //Vérification que l'utilisateur fournie existe
        if(commentaire.getUserId()==null) {
            log.error("L'utilisateur lié au commentaire n'existe pas" + commentaire.getUserId());
            throw new CommentaireCreateException(("L'utilisateur lié au commentaire n'existe pas"));
        }

        Commentaire newCommentaire = commentaireService.addComment(commentaire);

        if (newCommentaire == null){
            return ResponseEntity.noContent().build();
        }


        return new ResponseEntity<>(commentaire, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Commentaire> updateComment(@RequestBody Commentaire commentaire, @PathVariable int id){
        log.info("Début méthode : updateComment()");
        if(commentaire == null) {
            log.error("Le commentaire est null");
            throw new CommentaireCreateException("Le commentaire est null");
        }
     /*   if(commentaire.getId()==null) {
            log.error("Le commentaire fourni n'existe pas");
            throw new CommentaireCreateException("Le commentaire fourni n'existe pas");
        }*/
        log.info("Mise à jour du commentaire");

       // Optional<Commentaire> commentToUpdate = commentaireService.findById(id);



        return new ResponseEntity<>(commentaireService.updateCommentaire(commentaire, id),HttpStatus.CREATED);
    }


    // recuperer les commentaires d'un utilisateur = findByUser

    @GetMapping(value = "/user/{userId}")
    public List<Commentaire> findByUser(@PathVariable String userId){
        log.info("Début méthode : findByUser()");
        List<Commentaire> commentaires = commentaireService.findByUser(userId);
        if(commentaires == null || commentaires.isEmpty()){
            throw new CommentaireNotFoundException("Aucun commentaire n'est renseigné sur cetutilisateur");
        }
        return commentaires;
    }

    // supprimer un commentaire = deleteCommentById
    @DeleteMapping(value = "/delete/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer commentId){
        log.info("Début méthode : deleteComment()");
        Optional<Commentaire> commentToDelete = commentaireService.findById(commentId);
        commentaireService.deleteCommentaireById(commentId);

        return new ResponseEntity<>("Le commentaire d'id " + commentId + " a bien été supprimé", HttpStatus.GONE);
    }


}
