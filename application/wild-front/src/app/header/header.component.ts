import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isUserLoggedIn : boolean = false;
  
  constructor() { 
    setTimeout(
      () => {
        this.isUserLoggedIn = true;
      }, 10000
    );
  }

  ngOnInit() {
  }

}
