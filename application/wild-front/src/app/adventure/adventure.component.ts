import { Component, OnInit } from "@angular/core";
import { Adventure } from "../shared/model/adventure";
import { ActivatedRoute } from "@angular/router";
import { AdventureService } from "../services/adventure.service";

@Component({
  selector: "app-adventure",
  templateUrl: "./adventure.component.html",
  styleUrls: ["./adventure.component.css"]
})
export class AdventureComponent implements OnInit {
  public allAdventures: Adventure[] = [];
  public adventure: Adventure;
  public totalPages : number;
  public pages : Array<number>;
  public adventureList: Adventure[] = [];
  public currentPage:number = 0;
  public size:number = 7;
  public callOnInit:boolean = true;
  public itemsLoaded : boolean;
  constructor(
    private route: ActivatedRoute,
    private adventureService: AdventureService
  ) {
    setTimeout(() => {
      this.itemsLoaded = true;
    }, 3000);
  }

  ngOnInit() {
    if(this.callOnInit){
      this.getAllAventures()
    }
  }

  getAllAventures() {
    this.adventureList = [];
    this.adventureService.getAllAdventures(this.currentPage, this.size).subscribe(res => {
      this.allAdventures = res['content'];
      console.log("this.allAdventures", res);
      for (let i = 1; i < this.allAdventures.length; i++) {
        this.adventureList.push(this.allAdventures[i]);
      }
      this.totalPages = res['totalPages'];
      this.pages = new Array<number>(this.totalPages);
    
    });
  }

  getPage(i){
    this.currentPage = i;
    this.callOnInit = false;
    this.getAllAventures();
  }

  getAventureById(id: number) {
    return this.adventureService.getAdventureById(id).subscribe(res => {
      this.adventure = res;
      console.log("adventure by Id is good avec id :", this.adventure);
    });
  }
}
