import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../models/Product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  base_URL = 'http://localhost:8080/insurance/product';

  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.base_URL);
  }
  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(this.base_URL + "/" + id);
  }
  createProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.base_URL, product);
  }
  updateProduct(product: Product): Observable<Product> {
    return this.http.put<Product>(this.base_URL, product);
  }
  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(this.base_URL + "/" + id);
  }
}
