import { Component, OnInit } from '@angular/core';
import { OrderService } from '../services/order.service';
import { Order } from '../shared/model/order';
import { AdventureService } from '../services/adventure.service';
import { Adventure } from '../shared/model/adventure';
import { SessionService } from '../services/session.service';
import { Session } from '../shared/model/session';
import { User } from '../shared/model/user';

@Component({
  selector: 'app-orders-history',
  templateUrl: './orders-history.component.html',
  styleUrls: ['./orders-history.component.css']
})
export class OrdersHistoryComponent implements OnInit {

  public userOrders : Order[] = [];
  public adventure : Adventure;
  public userInfos : User;
  public sessions : Session[];
  public order : Order;
  public advHistory : Adventure;
  constructor(private orderService : OrderService, private adventureService : AdventureService, private sessionService:SessionService) { }

  ngOnInit() {
    this.userInfos = JSON.parse(sessionStorage.getItem("user-connected"));
    this.getUserOrders(this.userInfos.id);
    let userOrders = JSON.parse(sessionStorage.getItem("user-orders"));
    this.getUserOrderSession(userOrders);
    let userOrdersSession = JSON.parse(sessionStorage.getItem("user-order-sessions"));
    this.getAdventureBySession(userOrdersSession);
  }
  getAdventureBySession(userOrdersSession:Session[]) {
    userOrdersSession.forEach(userSession => {
      this.adventureService.getAdventureById(userSession.adventureId).subscribe((res) =>{
        console.log("this.adventureHistory", res);
        this.adventure = res;
      })
    })
  }

  getUserOrders(userId){
    this.orderService.getAllUserOrders(userId).subscribe((res) =>{
      this.userOrders = res;
      this.userOrders.forEach(order => {
        this.getAdvByOrder(order.id);
      })
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

  getOrderById(orderId : number){
    this.orderService.getOderById(orderId).subscribe((res) => {
      sessionStorage.setItem("orderById", JSON.stringify(res));
    })
  }

  getAdvByOrder(orderId : number){
    this.getOrderById(orderId);
    this.order = JSON.parse(sessionStorage.getItem("orderById"));
    this.order.orderSessions.forEach(orderSession => {
      this.sessionService.getAdventureBySessionId(orderSession.sessionId).subscribe(res => {
        this.advHistory = res;
      })
    })
  }
}
