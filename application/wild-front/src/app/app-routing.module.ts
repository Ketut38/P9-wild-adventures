import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AdventureComponent } from "./adventure/adventure.component";
import { AdventureDetailsComponent } from "./adventure-details/adventure-details.component";
import { CategoryComponent } from "./category/category.component";
import { AdventuresByCategoryComponent } from './adventures-by-category/adventures-by-category.component';
import { SessionsByAdventureComponent } from './sessions-by-adventure/sessions-by-adventure.component';
import { HomeComponent } from './home/home.component';
import { ProfilComponent } from './profil/profil.component';


const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "adventures", component: AdventureComponent },
  { path: "adventures/:id", component: AdventureDetailsComponent },
  { path: "adventuresByCategory/:id/adventures/:id/sessions", component: SessionsByAdventureComponent },
  { path : "adventuresByCategory/:id", component : AdventuresByCategoryComponent}, 
  { path: "adventures/:id/sessions", component: SessionsByAdventureComponent }, 
  { path: "profil", component: ProfilComponent},
  { path: "categories", component: CategoryComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
