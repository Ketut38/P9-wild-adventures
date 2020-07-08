import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AdventureComponent } from "./adventure/adventure.component";

const routes: Routes = [
  { path: "", component: AdventureComponent },
  { path: "adventure", component: AdventureComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
