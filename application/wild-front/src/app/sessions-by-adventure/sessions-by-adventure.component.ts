import { Component, OnInit } from '@angular/core';
import { Session} from '../shared/model/session';
import { Order } from '../shared/model/order';
import { SessionService } from '../services/session.service';
import { ActivatedRoute } from '@angular/router';
import { Adventure } from '../shared/model/adventure';
import { AdventureService } from '../services/adventure.service';
import { WildEventService } from '../services/wild-event.service';

@Component({
  selector: 'app-sessions-by-adventure',
  templateUrl: './sessions-by-adventure.component.html',
  styleUrls: ['./sessions-by-adventure.component.css']
})
export class SessionsByAdventureComponent implements OnInit {
  
  public sessionsByAdv : Session[] = [];
  public sessionsIdsStored :  number[] = [];
  public advSessionsIds :  any[] = [1000];
  public sessionToStore : Session;
  public addedToBasket : boolean = false;
  public sessionAlreadyExist : boolean = false;
  public adv : Adventure[] = [];
  public itemsLoaded : boolean;

  public adventure: Adventure = {  id: null, 
                            title: '', 
                            description : '',
                            participantCount : null, 
                            location: "",
                            image: '', 
                            sessions: [],
                            category_id: null};

  constructor(private sessionService: SessionService, private adventureService : AdventureService, private route: ActivatedRoute, private events: WildEventService) { 
    setTimeout(() => {
      this.itemsLoaded = true;
    }, 3000);
  }

  ngOnInit() {
    const adventureId = +this.route.snapshot.paramMap.get('id');
    this.getAdventureById(adventureId) 
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

  getAdventureById(id: number) {
    return this.adventureService.getAdventureById(id).subscribe(res => {
      this.adventure = res;
    });
  }

  createOrderDemand(sessionId : number){
    this.sessionsIdsStored = JSON.parse(sessionStorage.getItem("sessionsIdsStored"));
    if(this.sessionsIdsStored === null){
      this.sessionsIdsStored = new Array();;
    }
    if(this.sessionsIdsStored != null){
      this.sessionsIdsStored.forEach(id => {
        if(sessionId === id){
          this.sessionAlreadyExist = true;
        }
      });
    }
    if(!this.sessionAlreadyExist){
      let advSession = [+this.route.snapshot.paramMap.get('id'), sessionId]
      this.advSessionsIds.push(advSession);
      sessionStorage.setItem("advSession", JSON.stringify(this.advSessionsIds));

      this.sessionsIdsStored.push(sessionId);
      sessionStorage.setItem("sessionsIdsStored", JSON.stringify(this.sessionsIdsStored));
      this.changeAddedBasket();
    }
    const advId = +this.route.snapshot.paramMap.get('id');
    this.adv = JSON.parse(sessionStorage.getItem("adv"));
    if(this.adv == null){
      this.adv = new Array<Adventure>();
    }
    this.adventureService.getAdventureById(advId).subscribe((res)=>{
      this.adv.push(res);
      sessionStorage.setItem("adv", JSON.stringify(this.adv));
    })
    setTimeout(
      () => {
        this.sessionAlreadyExist = false;
      }, 3000);
    this.events.publish("wild.order.demand:refresh");
      
  }

  changeAddedBasket(){
    this.addedToBasket = true;
    setTimeout(
      () => {
        this.addedToBasket = false;
      }, 3000);
  }



}
