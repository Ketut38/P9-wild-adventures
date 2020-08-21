import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { apiOrders } from '../shared/constants';
import { Order } from '../shared/model/order';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: "root"
})
export class OrderService {
  constructor(private http: HttpClient) {}

  getAllUserOrders(userId: number): Observable<Order[]> {
    return this.http.get<Order[]>(apiOrders + '/user/' + userId);
  
  }
}
