import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiCommentaire } from '../shared/constants';
import { Commentaire } from '../shared/model/commentaire';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentaireService {
  constructor(private http: HttpClient) {}

  getCommentsByAdventure(adventureId: number): Observable<Commentaire[]> {
    return this.http.get<Commentaire[]>(apiCommentaire + '/adventure/' + adventureId);
  
  }

  saveCommentaire(commentaire : Commentaire){
  return this.http.post(apiCommentaire + '/add', commentaire);
}

deleteCommentaire(commentaireId: number){
  return this.http.delete(apiCommentaire + '/delete/' + commentaireId);
}

getCommentsByUser(userId: string): Observable<Commentaire[]> {
  return this.http.get<Commentaire[]>(apiCommentaire + '/user/' + userId);

}

}
