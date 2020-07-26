import { Component, OnInit } from '@angular/core';
import { SessionService } from '../services/session.service';
import { Session } from '../shared/model/session';import { AdventureService } from '../services/adventure.service';
import { Adventure } from '../shared/model/adventure';
import { element } from 'protractor';
;

@Component({
  selector: 'app-basket-details',
  templateUrl: './basket-details.component.html',
  styleUrls: ['./basket-details.component.css']
})
export class BasketDetailsComponent implements OnInit {
  public sessionIdsStored = [];
  public selectedSessions : Session[] = [];
  public adventure : Adventure;
  constructor(private sessionService : SessionService, private adventureService : AdventureService) { }

  ngOnInit() {
    this.getAllSessionsStoredByUser();
  }

  getAllSessionsStoredByUser(){
    this.sessionIdsStored = JSON.parse(sessionStorage.getItem("sessionsIdsStored"));
    this.sessionIdsStored.shift();
    this.sessionIdsStored.forEach(sessionId => {
      this.sessionService.getSessionById(sessionId).subscribe((res) => {
        this.selectedSessions.push(res)
      })
    })
  }

  getAdventureBySession(id : number){
    this.adventureService.getAdventureById(id).subscribe((res) => {
      this.adventure = res;
    })
  }
  deleteItemFromBasket(id : number){
    console.log("Session à supprimer");
  }
}
