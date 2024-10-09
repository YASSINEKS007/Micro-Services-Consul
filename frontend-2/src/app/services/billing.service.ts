import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Bill} from '../models/Bill.model';

@Injectable({
  providedIn: 'root'
})
export class BillingService {

  constructor(private http: HttpClient) {
  }

  loadBillsByCustomerId(customerId: number): Observable<Bill[]> {
    return this.http.get<Bill[]>(`http://localhost:8080/billing-service/orders-by-user/${customerId}`);
  }
}
