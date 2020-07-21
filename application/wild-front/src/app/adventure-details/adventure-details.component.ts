import { Component, OnInit } from '@angular/core';
import { Adventure } from '../shared/model/adventure';
import { ActivatedRoute } from '@angular/router';
import { AdventureService } from '../services/adventure.service';

@Component({
  selector: 'app-adventure-details',
  templateUrl: './adventure-details.component.html',
  styleUrls: ['./adventure-details.component.css']
})
export class AdventureDetailsComponent implements OnInit {
  adventure: Adventure = {
    id: null,
    title: '',
    description: '',
    location: '',
    price: null,
    image: '',
    participantCount: null,
    sessions: null,
    category_id: null
  };
  private id: number;
  private adventureId: number;

  constructor(
    public activatedRoute: ActivatedRoute,
    private adventureService: AdventureService
  ) {}

  ngOnInit() {
    this.adventureId = this.activatedRoute.snapshot.params['id'];
    this.getAdventureById(this.adventureId);
  }

  getAdventureById(id: number) {
    return this.adventureService.getAdventureById(id).subscribe(res => {
      this.adventure = res;
      console.log('aventure by Id is good avec id :', this.adventure);
    });
  }
}
