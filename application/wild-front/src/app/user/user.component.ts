import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../shared/model/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public user: User = {
    id: null,
    userName: '',
    password: '',
    firstname: '',
    lastname: '',
    gender: '',
    email: '',
    address: '',
    postcode: null,
    phoneNumber: ''
  };

  constructor(
    private userService: UserService
    ) {}

  ngOnInit() {
    this.getUserInfos();
  }
getUserInfos() {
  this.userService.getUserInfos().subscribe(res => {
    this.user = res;
  });
}
}
