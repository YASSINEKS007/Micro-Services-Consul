import {Component, OnInit} from '@angular/core';
import {BillingService} from '../services/billing.service';
import {ActivatedRoute} from '@angular/router';
import {Bill} from '../models/Bill.model';

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
})
export class BillsComponent implements OnInit {
  userId!: number;

  constructor(private billsService: BillingService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const userIdString = params.get('id');
      if (userIdString) {
        this.userId = +userIdString;
      }
      this.loadBillsByCustomerId(this.userId);
    });
  }

  loadBillsByCustomerId(id: number) {
    this.billsService.loadBillsByCustomerId(id).subscribe(
      {
        next: (data: Bill[]) => {
          console.log(data);
        }
        ,
        error: error => {
          console.log(error);
        }
      }
    )
  }
}
