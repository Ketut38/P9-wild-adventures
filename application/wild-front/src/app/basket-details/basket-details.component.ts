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
  public ordersDemand = [];
  public selectedSessions : Session[] = [];
  public adventure : Adventure;
  constructor(private sessionService : SessionService, private adventureService : AdventureService) { }

  ngOnInit() {
    this.getAllOrderDemandsByUser();
  }

  getAllOrderDemandsByUser(){
    this.ordersDemand = JSON.parse(sessionStorage.getItem("orderDemands"));
    this.ordersDemand.shift();
    this.ordersDemand.forEach(orderDemand => {
      this.sessionService.getSessionById(orderDemand.sessionId).subscribe((res) => {
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
