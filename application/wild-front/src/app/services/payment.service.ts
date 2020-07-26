import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { apiPayment, apiOrders } from '../shared/constants';
import { Order } from '../shared/model/order';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) {}


chargeCard(token: string, montant : string) {
    //const headers = new Headers({'token': token, 'amount': 100});
 return this.http.post(apiPayment + '/charge' , {},  {
              headers: new HttpHeaders()
                .set('token', token)
                .set('amount', montant)
      })
      
}

getAllUserOrders(userId: number): Observable<Order[]> {
  return this.http.get<Order[]>(apiOrders + '/user/' + userId);

}

getCommandeById(id: number): Observable<Order> {
  return this.http.get<Order>(apiOrders + '/' + id);
}

updateCommande(orderId): Observable<Order> {
  return this.http.put<Order>(apiOrders + '/update/' + orderId, orderId);
}

saveCommande(order : Order){
  return this.http.post(apiOrders + '/save/', order);
}
}