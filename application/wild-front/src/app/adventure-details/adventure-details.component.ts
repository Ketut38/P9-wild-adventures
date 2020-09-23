import { Component, OnInit } from '@angular/core';
import { Adventure } from '../shared/model/adventure';
import { ActivatedRoute } from '@angular/router';
import { AdventureService } from '../services/adventure.service';
import { CommentaireService } from '../services/commentaire.service';
import { Commentaire } from '../shared/model/commentaire';

@Component({
  selector: 'app-adventure-details',
  templateUrl: './adventure-details.component.html',
  styleUrls: ['./adventure-details.component.css']
})
export class AdventureDetailsComponent implements OnInit {
  adventure: Adventure = {
    id: null,
    title: "",
    description: "",
    location: "",
    image: "",
    participantCount: null,
    sessions: null,
    category_id: null
  };
  private id: number;
  private adventureId: number;
  public adventureComments : Commentaire[] = [];

  constructor(
    public activatedRoute: ActivatedRoute,
    private adventureService: AdventureService,
    private commentaireService: CommentaireService
  ) {}

  ngOnInit() {
    this.adventureId = this.activatedRoute.snapshot.params['id'];
    this.getAdventureById(this.adventureId);
    this.getCommentsByAdventure(this.adventureId);
    let adventureComments = JSON.parse(sessionStorage.getItem("adventure-comments"));
  }

  getAdventureById(id: number) {
    return this.adventureService.getAdventureById(id).subscribe(res => {
      this.adventure = res;
      console.log('aventure by Id is good avec id :', this.adventure);
    });
  }

  getCommentsByAdventure(adventureId: number){
    this.commentaireService.getCommentsByAdventure(adventureId).subscribe((res) =>{
      this.adventureComments = res;
      sessionStorage.setItem('adventure-comments', JSON.stringify(this.adventureComments));
      console.log("this.adventureComments", this.adventureComments)
    })
  
  }
}
