import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./header/header.component";
import { FooterComponent } from "./footer/footer.component";
import { UserService } from "./services/user.service";
import { OrderService } from "./services/order.service";
import { AdventureService } from "./services/adventure.service";
import { CategoryService } from "./services/category.service";
import { CommentService } from "./services/comment.service";
import { SessionService } from "./services/session.service";
import { CategoryComponent } from "./category/category.component";
import { AdventureComponent } from "./adventure/adventure.component";
import { HttpClientModule } from "@angular/common/http";
import { AdventureDetailsComponent } from './adventure-details/adventure-details.component';
import { AdventuresByCategoryComponent } from './adventures-by-category/adventures-by-category.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CategoryComponent,
    AdventureComponent,
    AdventureDetailsComponent,
    AdventuresByCategoryComponent
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [
    UserService,
    OrderService,
    AdventureService,
    CategoryService,
    CommentService,
    SessionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
