import { Component, OnInit } from '@angular/core';
import { CommentaireService } from '../services/commentaire.service';
import { Commentaire } from '../shared/model/commentaire';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../shared/model/user';


@Component({
  selector: 'app-user-comments',
  templateUrl: './user-comments.component.html',
  styleUrls: ['./user-comments.component.css']
})
export class UserCommentsComponent implements OnInit {
  
  public userInfos : User;
  public userCommentaires : Commentaire[] = [];
  

  constructor(private commentaireService : CommentaireService, private userService: UserService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {

   /* this.userInfos = JSON.parse(sessionStorage.getItem("userInfos"));
    if(this.userInfos === undefined || this.userInfos === null){
      this.userInfos = JSON.parse(sessionStorage.getItem("user-connected"));
    }
    this.getCommentsByUser(this.userInfos.id);

   // this.userInfos = JSON.parse(sessionStorage.getItem("user-connected"));
   // this.getCommentsByUser("8bbafda3-d0b8-4ae5-80ec-bf2a5e9eda71");
    let userCommentaires = JSON.parse(sessionStorage.getItem("user-comments"));*/

    this.userInfos = JSON.parse(sessionStorage.getItem("userInfos"));
    if(this.userInfos === undefined || this.userInfos === null){
      this.getConnectedUser();
      this.userInfos = JSON.parse(sessionStorage.getItem("user-infos-for-history"));
    }
    this.getCommentsByUser(this.userInfos.id);
    let userOrders = JSON.parse(sessionStorage.getItem("user-orders"));
    
  }

  getConnectedUser(){
    this.userService.getUserInfos().subscribe((res) => {
      sessionStorage.setItem('user-infos-for-history', JSON.stringify(res));
    })
  }

  getCommentsByUser(userId){
    this.commentaireService.getCommentsByUser(userId).subscribe((res) =>{
      this.userCommentaires = res;
      sessionStorage.setItem('user-comments', JSON.stringify(this.userCommentaires));
      console.log("this.userCommentaires", this.userCommentaires)
    })
  
  }

  

}
