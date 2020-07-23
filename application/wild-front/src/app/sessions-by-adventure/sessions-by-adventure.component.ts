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
  public addedToBasket : boolean = false;
  public sessionAlreadyExist : boolean = false;
  public orders = [{id : 100, sessionId: 100, userId: 100, date: new Date()}];
  order: Order = {  
    id: null,
    userId: null,
    sessionId: null,
    date: null,
    isPaid: false
  }

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
    this.order.id = Math.floor(Math.random() * 100);;
    this.order.sessionId = sessionId;
    this.order.userId = parseInt(sessionStorage.getItem("userId"));
    this.order.date = new Date();
    let ordersFromSession = JSON.parse(sessionStorage.getItem("orderDemands"));
    if(ordersFromSession != null){
      ordersFromSession.forEach(element => {
        if(this.order.id === element.id){
          this.sessionAlreadyExist = true;
        }
      });
    }
    if(this.sessionAlreadyExist === false){
      this.orders.push(this.order);
      sessionStorage.setItem("orderDemands", JSON.stringify(this.orders));
      this.changeAddedBasket();
    }
  }

  changeAddedBasket(){
    this.addedToBasket = true;
    setTimeout(
      () => {
        this.addedToBasket = false;
      }, 3000);
  }



}
