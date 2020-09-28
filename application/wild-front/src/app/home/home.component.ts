import { Component, OnInit } from '@angular/core';
import { Adventure } from '../shared/model/adventure';
import { AdventureService } from '../services/adventure.service';
import { SessionService } from '../services/session.service';
import { Order } from '../shared/model/order';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public allAdventures: Adventure[] = [];
  public adventure: Adventure;
  public adventureList: Adventure[] = [];
  public currentPage:number = 0;
  public size:number = 5;
  public totalPages : number;
  public pages : Array<number>;
  constructor(
    private adventureService: AdventureService, private sessionService : SessionService, 
    private orderService: OrderService
  ) {}

  ngOnInit() {
  }

  getAllAventures() {
    this.adventureService.getAllAdventures(this.currentPage, this.size).subscribe(res => {
      this.allAdventures = res;
      this.totalPages = res['totalPages'];
      this.pages = new Array<number>(this.totalPages);
      for (let i = 1; i < this.allAdventures.length; i++) {
        this.adventureList.push(this.allAdventures[i]);
      }
    });
  }
}
