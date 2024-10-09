import {Component, OnInit} from '@angular/core';
import {ProductsService} from '../services/products.service';
import {Product} from '../models/Product.model';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']  // Corrected property name
})
export class ProductsComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'price', 'quantity'];
  dataSource: Product[] = [];

  constructor(private productsService: ProductsService) { }

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts() {
    this.productsService.loadProducts().subscribe({
      next: (data: Product[]) => {
        this.dataSource = data;
        console.log(data);
      },
      error: (error) => {
        console.log(error);
      }
    });
  }
}
