import { Component, OnInit } from '@angular/core';
import { SessionService } from '../services/session.service';
import { Session } from '../shared/model/session';import { AdventureService } from '../services/adventure.service';
import { Adventure } from '../shared/model/adventure';
import { element } from 'protractor';
import { Router } from '@angular/router';
;

@Component({
  selector: 'app-basket-details',
  templateUrl: './basket-details.component.html',
  styleUrls: ['./basket-details.component.css']
})
export class BasketDetailsComponent implements OnInit {
  public sessionIdsStored = [];
  public orderAmount = 0;
  public selectedSessions : Session[] = [];
  public sessions : Session[] = [];
  public adventure : Adventure;
  public adv : Adventure[] = [];
  itemDeleted: boolean;
  constructor(private sessionService : SessionService, private adventureService : AdventureService, private router : Router) { }

  ngOnInit() {
    this.getAllSessionsStoredByUser();
  }

  getAllSessionsStoredByUser(){
    this.sessionIdsStored = JSON.parse(sessionStorage.getItem("sessionsIdsStored"));
    this.sessionIdsStored.shift();
    this.sessionIdsStored.forEach(sessionId => {
      this.sessionService.getSessionById(sessionId).subscribe((res) => {
        this.selectedSessions.push(res)
        this.orderAmount = this.orderAmount + res.price;
      })
    })
    this.adv = JSON.parse(sessionStorage.getItem("adv"));
    sessionStorage.setItem('sessionsIdsStoredForOrders', JSON.stringify(this.sessionIdsStored));
  }

  getAdventureBySession(index : number){
    this.adv = JSON.parse(sessionStorage.getItem("adv"));
    this.adventure = this.adv[index];
    return this.adventure;
  }

  deleteItemFromBasket(index:number){
    this.selectedSessions.splice(index, 1);
    this.itemDeleted = true;
    this.selectedSessions = [...this.selectedSessions];
    this.orderAmount = 0;
    this.selectedSessions.forEach(selectedSession => {
      this.orderAmount = this.orderAmount - selectedSession.price;
    })
    this.orderAmount = Math.abs(this.orderAmount);
    setTimeout(
      () => {
        this.itemDeleted = false; 
    }, 2000);
  }
}
