import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CustomersComponent} from './customers/customers.component';
import {ProductsComponent} from './products/products.component';
import {BillsComponent} from './bills/bills.component';

const routes: Routes = [
  {path: "customers", component: CustomersComponent},
  {path: "products", component: ProductsComponent},
  {path: "bills/:id", component: BillsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
