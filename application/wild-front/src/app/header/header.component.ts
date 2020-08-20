import { Component, OnInit, Inject } from '@angular/core';
import { Adventure } from '../shared/model/adventure';
import { AuthGuard} from '../auth.guard';
import { KeycloakService } from 'keycloak-angular';
import { DOCUMENT } from '@angular/common';
import { UserService } from '../services/user.service';
import { User } from '../shared/model/user';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public sessionsStored = [];
  public user = {};
  public adv: Adventure;
  isUserLoggedIn: boolean;
  private authGuard: AuthGuard;
  // tslint:disable-next-line: max-line-length
  logoutURI = 'http://localhost:8080/auth/realms/WildAdventures/protocol/openid-connect/logout?redirect_uri=http://localhost:4200/';


  constructor(
    @Inject(DOCUMENT) private document: Document,
    protected readonly keycloak: KeycloakService,
    private userService: UserService
  ){}

  ngOnInit() {
    this.getAllOrderDemandsByUser();
    this.checkUserLoggedIn();
  }

  checkUserLoggedIn(): boolean {
    this.user = JSON.parse(sessionStorage.getItem("userInfos"));  
    if (this.user) {
      this.isUserLoggedIn = true;
    } else {
      this.isUserLoggedIn = false;
    }
    return this.isUserLoggedIn;
  }

 /* logout() {
    this.keycloak.logout();
    this.router.navigate(['/logout']);
}*/

public logout() {
  sessionStorage.removeItem("userInfos");
  this.document.location.href = this.logoutURI;
}

  getAllOrderDemandsByUser(){
    this.sessionsStored = JSON.parse(sessionStorage.getItem('sessionsIdsStored'));
  }

}
