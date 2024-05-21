import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../models/Product";

@Injectable({
  providedIn: 'root'
})
export class ComparatorService {

  base_URL = 'http://localhost:8080/insurance/comparator';
  constructor(private http: HttpClient) { }
  recommendProduct(age: number,
                   diabetics: string,
                   highBloodPressure: string,
                   travelDays: number): Observable<Product> {
    return this.http.get<Product>(this.base_URL + "/" + age
    + "/" + diabetics + "/" + highBloodPressure + "/" + travelDays);
  }
}
