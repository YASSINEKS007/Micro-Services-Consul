import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BillingService {

  constructor(private http: HttpClient) {
  }

  loadBillsByCustomerId(customerId: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/billing-service/orders-by-user/${customerId}`);
  }
}
