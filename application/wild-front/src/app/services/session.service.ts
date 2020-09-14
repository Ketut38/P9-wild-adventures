import { Injectable } from "@angular/core";
import { Observable } from 'rxjs';
import { Adventure } from '../shared/model/adventure';
import { HttpClient } from '@angular/common/http';

import {apiSession} from "../shared/constants";
import { Session } from '../shared/model/session';
@Injectable({
  providedIn: 'root'
})
export class SessionService {
  constructor(private http: HttpClient) {}

  getSessionsByAdventure(id: number): Observable<Session[]> {
    return this.http.get<Session[]>(apiSession + "/adventure/" + id) ;
  }

  getSessionById(id: number): Observable<Session> {
    return this.http.get<Session>(apiSession + "/single/" + id) ;
  }

  getAdventureBySessionId(sessionId: number): Observable<Adventure> {
    return this.http.get<Adventure>(apiSession + "/" + sessionId + "/adventure") ;
  }
}
