import { Component, OnInit } from '@angular/core';
import { Adventure } from '../shared/model/adventure';
import { AdventureService } from '../services/adventure.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public allAdventures: Adventure[] = [];
  public adventure: Adventure;
  public adventureList: Adventure[] = [];
  constructor(
    private adventureService: AdventureService
  ) {}

  ngOnInit() {
    this.getAllAventures();
  }

  getAllAventures() {
    this.adventureService.getAllAdventures().subscribe(res => {
      this.allAdventures = res;

      for (let i = 1; i < 5; i++) {
        this.adventureList.push(this.allAdventures[i]);
      }
    });
  }
}
