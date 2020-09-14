import { Component, OnInit, Inject } from '@angular/core';
import { Adventure } from '../shared/model/adventure';

import { logoutURI, registerURI } from '../shared/constants';
import { DOCUMENT } from '@angular/common';
import { UserService } from '../services/user.service';
import { WildEventService } from '../services/wild-event.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public sessionsStored = [];
  public user = {};
  public adv: Adventure;
  protected isUserLoggedIn: boolean;
  // tslint:disable-next-line: max-line-length

  constructor(
    @Inject(DOCUMENT) private document: Document,
    private userService: UserService, private events:WildEventService
  ) {
    this.events.subscribe("wild.order.demand:refresh", () => {
      this.getAllOrderDemandsByUser();
    });
  }


  ngOnInit() {
    this.checkUserLoggedIn();
  }

  checkUserLoggedIn() {
    this.userService.getUserInfos().subscribe(res => {
      this.user = res;
      if (Object.keys(res).length === 0) {
        this.isUserLoggedIn = false;
      } else {
        this.isUserLoggedIn = true;
      }
    });
    return this.isUserLoggedIn;
  }

logout() {
  sessionStorage.removeItem('userInfos');
  this.document.location.href = logoutURI;
}

register(){
  this.document.location.href = registerURI;
}

getAllOrderDemandsByUser(){
    this.sessionsStored = JSON.parse(sessionStorage.getItem('sessionsIdsStored'));
}

}
