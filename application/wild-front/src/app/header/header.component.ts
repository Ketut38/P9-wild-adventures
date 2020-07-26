import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public sessionsStored = [];
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
    this.sessionsStored = JSON.parse(sessionStorage.getItem("sessionsIdsStored"));
    console.log("this.ordersDemand", this.sessionsStored);
  }

}
