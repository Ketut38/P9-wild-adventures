import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { apiPayment, apiOrders } from '../shared/constants';
import { Order } from '../shared/model/order';
import { Payment } from '../shared/model/payment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) {}


chargeCard(token: string, amount : string) {
  let req = new Payment()
  req.token = token;
  req.amount = amount;
 return this.http.post(apiPayment + 'charge', req)   
}

getAllUserOrders(userId: number): Observable<Order[]> {
  return this.http.get<Order[]>(apiOrders + '/user/' + userId);

}

getOrderById(id: number): Observable<Order> {
  return this.http.get<Order>(apiOrders + '/' + id);
}

updateOrder(orderId): Observable<Order> {
  return this.http.put<Order>(apiOrders + '/update/' + orderId, orderId);
}

saveOrder(order : Order){
  return this.http.post(apiOrders + '/save', order);
}
}