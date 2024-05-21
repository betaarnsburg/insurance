import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../models/Order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  base_URL = 'http://localhost:8080/insurance/order';

  constructor(private http: HttpClient) { }

  getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.base_URL);
  }
  getOrderById(id:number): Observable<Order> {
    return this.http.get<Order>(this.base_URL + "/" + id);
  }
  creatOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(this.base_URL, order);
  }
  updateOrder(order: Order): Observable<Order> {
    return this.http.put<Order>(this.base_URL, order);
  }
  deleteOrder(id:number): Observable<void> {
    return this.http.delete<void>(this.base_URL + "/" + id);
  }
}
