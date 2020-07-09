import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AdventureComponent } from "./adventure/adventure.component";
import { AdventureDetailsComponent } from "./adventure-details/adventure-details.component";
import { CategoryComponent } from "./category/category.component";

const routes: Routes = [
  { path: "", component: AdventureComponent },
  { path: "adventure", component: AdventureComponent },
  { path: "adventure/:id", component: AdventureDetailsComponent },
  { path: "categories", component: CategoryComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
