import { Component, OnInit } from '@angular/core';
import { Adventure } from '../shared/model/adventure';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public sessionsStored = [];
  public adv: Adventure;
  isUserLoggedIn : boolean = false;
  
  constructor() { 
    setTimeout(
      () => {
        this.isUserLoggedIn = true;
        sessionStorage.setItem('userId', JSON.stringify(1))
      }, 5000
    );
  }

  ngOnInit() {
    this.getAllOrderDemandsByUser();
  }

  getAllOrderDemandsByUser(){
    this.sessionsStored = JSON.parse(sessionStorage.getItem("sessionsIdsStored"));
  }

}
