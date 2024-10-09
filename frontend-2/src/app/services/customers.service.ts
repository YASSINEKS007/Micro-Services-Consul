import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../models/Customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {

  constructor(private http: HttpClient) {
  }

  loadCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>('http://localhost:8080/customer-service/customers');
  }
}
