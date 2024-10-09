import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../models/Product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) {
  }

  loadProducts(): Observable<Product[]> {
    return this.http.get<Product[]>("http://localhost:8080/inventory-service/products");
  }
}
