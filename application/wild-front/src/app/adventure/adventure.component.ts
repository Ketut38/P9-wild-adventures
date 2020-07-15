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
  public adventureList: Adventure[] = [];
  constructor(
    private route: ActivatedRoute,
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
      console.log("getAllAventures", this.allAdventures);
    });
  }

  getAventureById(id: number) {
    return this.adventureService.getAdventureById(id).subscribe(res => {
      this.adventure = res;
      console.log("adventure by Id is good avec id :", this.adventure);
    });
  }
}
