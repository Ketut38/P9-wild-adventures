import { NgModule, InjectionToken } from '@angular/core';
import { Routes, RouterModule, ActivatedRouteSnapshot } from '@angular/router';
import { AdventureComponent } from './adventure/adventure.component';
import { AdventureDetailsComponent } from './adventure-details/adventure-details.component';
import { CategoryComponent } from './category/category.component';
import { AdventuresByCategoryComponent } from './adventures-by-category/adventures-by-category.component';
import { SessionsByAdventureComponent } from './sessions-by-adventure/sessions-by-adventure.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './auth.guard';
import { BasketDetailsComponent } from './basket-details/basket-details.component';
import { PaymentComponent } from './payment/payment.component';
import { OrdersHistoryComponent } from './orders-history/orders-history.component';


const externalUrlProvider = new InjectionToken('externalUrlRedirectResolver');


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'logout', component: HomeComponent },
  { path: 'adventures', component: AdventureComponent },
  { path: 'adventures/:id', component: AdventureDetailsComponent },
  { path: 'adventuresByCategory/:id/adventures/:id/sessions', component: SessionsByAdventureComponent },
  { path : 'adventuresByCategory/:id', component : AdventuresByCategoryComponent},
  { path: 'adventures/:id/sessions', component: SessionsByAdventureComponent },
  { path: 'categories', component: CategoryComponent },
  { path: 'basket-details', component: BasketDetailsComponent },
  { path: 'payment/commande/:price', component: PaymentComponent },
  { path: 'profil', component: UserComponent, canActivate: [AuthGuard]},
  { path: 'profil/orders', component: OrdersHistoryComponent, canActivate: [AuthGuard] },
  { path: 'externalRedirect', resolve: {url: externalUrlProvider}, component: HomeComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthGuard,
    {
      provide: externalUrlProvider,
      useValue: (route: ActivatedRouteSnapshot) => {
          const externalUrl = route.paramMap.get('externalUrl');
          window.open(externalUrl, '_self');
      },
  },
  ]
})
export class AppRoutingModule {}
