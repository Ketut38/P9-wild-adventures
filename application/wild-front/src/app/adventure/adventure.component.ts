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
  public allAventures: Adventure[] = [];
  public aventuresByCat: Adventure[] = [];
  public aventure: Adventure;
  public aventureList: Adventure[] = [];
  constructor(
    private route: ActivatedRoute,
    private adventureService: AdventureService
  ) {}

  ngOnInit() {
    this.getAllAventures();
  }

  getAllAventures() {
    this.adventureService.getAllAdventures().subscribe(res => {
      this.allAventures = res;

      for (let i = 1; i < 5; i++) {
        this.aventureList.push(this.allAventures[i]);
      }
      console.log("getAllAventures", this.allAventures);
    });
  }

  getAventureById(id: number) {
    return this.adventureService.getAdventureById(id).subscribe(res => {
      this.aventure = res;
      console.log("aventure by Id is good avec id :", this.aventure);
    });
  }
}
