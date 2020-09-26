import { Component, OnInit } from '@angular/core';
import { CommentaireService } from '../services/commentaire.service';
import { Commentaire } from '../shared/model/commentaire';


@Component({
  selector: 'app-user-comments',
  templateUrl: './user-comments.component.html',
  styleUrls: ['./user-comments.component.css']
})
export class UserCommentsComponent implements OnInit {

  public userCommentaires : Commentaire[] = [];

  constructor(private commentaireService : CommentaireService) { }

  ngOnInit() {
    this.getCommentsByUser("943b47b7-f336-4929-b557-7123aed78a96");
    let userCommentaires = JSON.parse(sessionStorage.getItem("user-comments"));
  }

  getCommentsByUser(userId){
    this.commentaireService.getCommentsByUser(userId).subscribe((res) =>{
      this.userCommentaires = res;
      sessionStorage.setItem('user-comments', JSON.stringify(this.userCommentaires));
      console.log("this.userCommentaires", this.userCommentaires)
    })
  
  }

}
