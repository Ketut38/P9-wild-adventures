import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public ordersDemand = [];
  isUserLoggedIn : boolean = false;
  
  constructor() { 
    setTimeout(
      () => {
        this.isUserLoggedIn = true;
        sessionStorage.setItem('userId', JSON.stringify(1))
      }, 10000
    );
  }

  ngOnInit() {
    this.getAllOrderDemandsByUser();
  }

  getAllOrderDemandsByUser(){
    this.ordersDemand = JSON.parse(sessionStorage.getItem("orderDemands"));
    console.log("this.ordersDemand", this.ordersDemand);
  }

}
