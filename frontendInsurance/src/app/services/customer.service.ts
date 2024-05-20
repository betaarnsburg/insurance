import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../models/Customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  base_URL = 'http://localhost:8080/insurance/customer';

  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.base_URL);
  }
  getCustomerById(id: number): Observable<Customer> {
    return this.http.get<Customer>(this.base_URL + "/" +id);
  }
  creatCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.base_URL, customer);
  }
  updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(this.base_URL, customer);
  }
  deleteCustomer(id: number): Observable<void> {
    return this.http.delete<void>(this.base_URL + "/" + id);
  }
}
