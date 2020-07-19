import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-basket-details',
  templateUrl: './basket-details.component.html',
  styleUrls: ['./basket-details.component.css']
})
export class BasketDetailsComponent implements OnInit {
  public ordersDemand = [];
  constructor() { }

  ngOnInit() {
    this.getAllOrderDemandsByUser();
  }

  getAllOrderDemandsByUser(){
    this.ordersDemand = JSON.parse(sessionStorage.getItem("orderDemands"));
    this.ordersDemand.shift();
    console.log("this.ordersDemand", this.ordersDemand);
  }
}
