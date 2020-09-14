import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../shared/model/user';
import { apiUserSession } from '../shared/constants';
import { Observable } from 'rxjs';

const headers = new HttpHeaders().set('Content-Type', 'application/json');

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  getUserInfos(): Observable<User> {
    return this.http.get<User>(apiUserSession, {headers});
  }
}
