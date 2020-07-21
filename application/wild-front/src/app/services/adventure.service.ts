import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Adventure } from '../shared/model/adventure';
import {
  apidAdventure,
  apidAdventureById,
  apidAdventureByCategory
} from '../shared/constants';
import { Session } from '../shared/model/session';

@Injectable({
  providedIn: 'root'
})
export class AdventureService {
  constructor(private http: HttpClient) {}

  getAllAdventures(): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(apidAdventure);
  }

  getAdventureById(id: number): Observable<Adventure> {
    return this.http.get<Adventure>(apidAdventureById + '/adventure/' + id);
  }

  getAventuresByCategory(id: number): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(
      apidAdventureByCategory + '/adventures'
    );
  }
}
