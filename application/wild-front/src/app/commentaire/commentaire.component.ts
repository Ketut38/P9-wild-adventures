import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../shared/model/user';
import { KeycloakService } from 'keycloak-angular';
import { Order } from '../shared/model/order';  
import { CommentaireService } from '../services/commentaire.service';
import { Commentaire } from '../shared/model/commentaire';
import { NgForm } from '@angular/forms'
import { SessionService } from '../services/session.service';
import { Session } from '../shared/model/session';import { AdventureService } from '../services/adventure.service';


@Component({
  selector: 'app-commentaire',
  templateUrl: './commentaire.component.html',
  styleUrls: ['./commentaire.component.css']
})
export class CommentaireComponent implements OnInit {
  public user : User;
  public createdCommentaire: any;
  public activatedRoute: ActivatedRoute;
  public commentaire = {
    id : null,
    userId: null,
    adventureId: null,
    contents: null,
    date: null,
  };

  constructor(private http: HttpClient,  protected readonly keycloak: KeycloakService,
    private userService: UserService,  private sessionService : SessionService, private router: Router, private commentaireService : CommentaireService, private route: ActivatedRoute) { }

  ngOnInit() {
    
  }

  onSubmit(form: NgForm) {
    const message = form.value['message'];
    const commande = form.value['commande'];
    const utilisateur = form.value['utilisateur'];

    this.createCommentaire(message, commande, utilisateur);

    this.router.navigate(['/profil/commentaires']);
    
    console.log(form.value);
}

  createCommentaire(message: string, commande: number, utilisateur: string){

  this.commentaire.date = new Date();
  //this.commentaire.adventureId = this.sessionService.getAdventureBySessionId(this.route.snapshot.params['id']);
  this.commentaire.adventureId = this.route.snapshot.params['id'];
  this.commentaire.userId = this.route.snapshot.params['userId'];

  this.commentaire.contents = message;

  this.commentaireService.saveCommentaire(this.commentaire).subscribe((res) => {
  this.createdCommentaire = res;
      
      })

  }

}
