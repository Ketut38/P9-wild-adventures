import { Component, OnInit } from '@angular/core';
import { Session} from '../shared/model/session';
import { Order } from '../shared/model/order';
import { SessionService } from '../services/session.service';
import { ActivatedRoute } from '@angular/router';
import { Adventure } from '../shared/model/adventure';
import { AdventureService } from '../services/adventure.service';

@Component({
  selector: 'app-sessions-by-adventure',
  templateUrl: './sessions-by-adventure.component.html',
  styleUrls: ['./sessions-by-adventure.component.css']
})
export class SessionsByAdventureComponent implements OnInit {

  public sessionsByAdv : Session[] = [];
  public sessionsIdsStored :  number[] = [1000];
  public sessionToStore : Session;
  public addedToBasket : boolean = false;
  public sessionAlreadyExist : boolean = false;
  public adv : Adventure;

  adventure: Adventure = {  id: null, 
                            title: '', 
                            description : '',
                            participantCount : null, 
                            location: "",
                            price: null,
                            image: '', 
                            sessions: [],
                            category_id: null};

  constructor(private sessionService: SessionService, private adventureService : AdventureService, private route: ActivatedRoute) { }

  ngOnInit() {
    const adventureId = +this.route.snapshot.paramMap.get('id');
    this.getSessionsByAdventure(adventureId);
  }

  getSessionsByAdventure(id : number){
    this.adventureService.getAdventureById(id).subscribe((res) =>{
      console.log("this.adventure", res)
      this.adventure = res;
    })
    this.sessionService.getSessionsByAdventure(id).subscribe((res) => {
      console.log("res", res);
      this.sessionsByAdv = res;
    }) 
  }

  createOrderDemand(sessionId : number){
    let sessionsAlreadyStored = JSON.parse(sessionStorage.getItem("sessionsIdsStored"));
    if(sessionsAlreadyStored != null){
      sessionsAlreadyStored.forEach(id => {
        if(sessionId === id){
          this.sessionAlreadyExist = true;
        }
      });
    }
    if(!this.sessionAlreadyExist){
      this.sessionsIdsStored.push(sessionId);
      sessionStorage.setItem("sessionsIdsStored", JSON.stringify(this.sessionsIdsStored));
      this.changeAddedBasket();
    }
    const advId = +this.route.snapshot.paramMap.get('id');
    this.adventureService.getAdventureById(advId).subscribe((res)=>{
      this.adv = res;
      sessionStorage.setItem("adv", JSON.stringify(this.adv));
    })
    setTimeout(
      () => {
        this.sessionAlreadyExist = false;
      }, 3000);
  }

  changeAddedBasket(){
    this.addedToBasket = true;
    setTimeout(
      () => {
        this.addedToBasket = false;
      }, 3000);
  }



}
