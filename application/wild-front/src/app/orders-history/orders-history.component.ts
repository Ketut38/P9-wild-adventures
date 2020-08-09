import { Component, OnInit } from '@angular/core';
import { OrderService } from '../services/order.service';
import { Order } from '../shared/model/order';
import { AdventureService } from '../services/adventure.service';
import { Adventure } from '../shared/model/adventure';
import { SessionService } from '../services/session.service';
import { Session } from '../shared/model/session';

@Component({
  selector: 'app-orders-history',
  templateUrl: './orders-history.component.html',
  styleUrls: ['./orders-history.component.css']
})
export class OrdersHistoryComponent implements OnInit {

  public userOrders : Order[] = [];
  public adventure : Adventure;
  public sessions : Session[];
  constructor(private orderService : OrderService, private adventureService : AdventureService, private sessionService:SessionService) { }

  ngOnInit() {
    this.getUserOrders(1);
    let userOrders = JSON.parse(sessionStorage.getItem("user-orders"));
    this.getUserOrderSession(userOrders);
    let userOrdersSession = JSON.parse(sessionStorage.getItem("user-order-sessions"));
    this.getAdventureBySession(userOrdersSession);
  }
  getAdventureBySession(userOrdersSession:Session[]) {
    userOrdersSession.forEach(userSession => {
      this.adventureService.getAdventureById(userSession.adventureId).subscribe((res) =>{
        this.adventure = res;
      })
    })
  }

  getUserOrders(userId){
    this.orderService.getAllUserOrders(userId).subscribe((res) =>{
      this.userOrders = res;
      sessionStorage.setItem('user-orders', JSON.stringify(this.userOrders));
      console.log("this.userOrders", this.userOrders);
    })
  }

  getUserOrderSession(orders:Order[]){
    this.sessions = new Array<Session>();
    orders.forEach(order => {
      order.orderSessions.forEach(orderSession => {
        this.sessionService.getSessionById(orderSession.sessionId).subscribe((res) =>{
          this.sessions.push(res);
          sessionStorage.setItem('user-order-sessions', JSON.stringify(this.sessions));
          console.log("this.sessions", this.sessions);
       })
      })
    })
  }
  

}
