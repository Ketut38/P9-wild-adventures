import { BrowserModule } from '@angular/platform-browser';
import { NgModule, APP_INITIALIZER } from '@angular/core';
import {KeycloakService} from 'keycloak-angular';
import {initializer} from '../environments/environment';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {TokenInterceptor} from './shared/service/TokenInterceptor';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { UserService } from './services/user.service';
import { OrderService } from './services/order.service';
import { AdventureService } from './services/adventure.service';
import { CategoryService } from './services/category.service';
import { CommentService } from './services/comment.service';
import { SessionService } from './services/session.service';
import { CategoryComponent } from './category/category.component';
import { AdventureComponent } from './adventure/adventure.component';

import { AdventureDetailsComponent } from './adventure-details/adventure-details.component';
import { AdventuresByCategoryComponent } from './adventures-by-category/adventures-by-category.component';
import { SessionsByAdventureComponent } from './sessions-by-adventure/sessions-by-adventure.component';
import { HomeComponent } from './home/home.component';
import { KeycloakAngularModule } from 'keycloak-angular';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CategoryComponent,
    AdventureComponent,
    AdventureDetailsComponent,
    AdventuresByCategoryComponent,
    SessionsByAdventureComponent,
    HomeComponent
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],

  providers: [
    UserService,
    OrderService,
    AdventureService,
    CategoryService,
    CommentService,
    SessionService,
    KeycloakService,
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      multi: true,
      deps: [KeycloakService]
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
