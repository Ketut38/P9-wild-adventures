import { BrowserModule } from '@angular/platform-browser';
import { NgModule, APP_INITIALIZER } from '@angular/core';
import { environment } from 'src/environments/environment';

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
import { HttpClientModule } from '@angular/common/http';
import { AdventureDetailsComponent } from './adventure-details/adventure-details.component';
import { AdventuresByCategoryComponent } from './adventures-by-category/adventures-by-category.component';
import { SessionsByAdventureComponent } from './sessions-by-adventure/sessions-by-adventure.component';
import { HomeComponent } from './home/home.component';
import { KeycloakService, KeycloakAngularModule } from 'keycloak-angular';

export function kcInitializer(keycloak: KeycloakService): () => Promise<any> {
  return (): Promise<any> => {
    return new Promise(async (resolve, reject) => {
      try {
        await keycloak.init(environment.keycloakOptions);
        console.log('Keycloak is initialized');
        resolve();
      } catch (error) {
        console.log('Error thrown in init ' + error);
        reject(error);
      }
    });
  };
}

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
    { provide: APP_INITIALIZER, useFactory: kcInitializer, multi: true, deps: [KeycloakService] }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
