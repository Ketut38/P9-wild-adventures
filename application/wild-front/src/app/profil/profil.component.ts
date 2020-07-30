import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  firstName: string;
  lastName: string;
  userName: string;
  gender: string;
  email: string;
  password: string;
  phoneNumber: string;
  dateInscription: string;
  

  constructor() {
    this.firstName = 'Clement';
    this.lastName = 'Biotteau';
    this.userName = 'Clem';
    this.gender = 'Male';
    this.email = 'clem.biotteau@gmail.com';
    this.password = '123456';
    this.phoneNumber = '0642335349';
    this.dateInscription = '01/03/2099'
   }

  ngOnInit() {}

    onClick() {
      alert('Afficher le formulaire de modifications');
    }
  

}
