import { Component, OnInit } from '@angular/core';
import { Session } from '../shared/model/session';
import { SessionService } from '../services/session.service';
import { ActivatedRoute } from '@angular/router';
import { Adventure } from '../shared/model/adventure';
import { AdventureService } from '../services/adventure.service';

@Component({
  selector: 'app-sessions-by-adventure',
  templateUrl: './sessions-by-adventure.component.html',
  styleUrls: ['./sessions-by-adventure.component.css']
})
export class SessionsByAdventureComponent implements OnInit {

  public sessions : Session[] = [];
  adventure: Adventure = {  id: null, 
                            title: '', 
                            description : '',
                            participantCount : null, 
                            location: "",
                            price: null,
                            image: '', 
                            sessions: [],
                            category_id: null};

  constructor(private sessionService: SessionService, private adventureService : AdventureService, private route: ActivatedRoute) { }

  ngOnInit() {
    const adventureId = +this.route.snapshot.paramMap.get('id');
    this.getSessionsByAdventure(adventureId);
  }

  getSessionsByAdventure(id : number){
    this.adventureService.getAdventureById(id).subscribe((res) =>{
      console.log("this.adventure", res)
      this.adventure = res;
    })
    this.sessionService.get
  }

}
