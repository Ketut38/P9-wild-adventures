import { User } from './shared/model/user';

import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  title = 'wild-front';
  profile: User;

  constructor() {}

  public ngOnInit(): void {

  }
}
