import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {CustomersComponent} from './customers/customers.component';
import {ProductsComponent} from './products/products.component';
import {provideHttpClient} from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import {NavbarComponent} from './navbar/navbar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule, MatIconButton} from '@angular/material/button';
import { BillsComponent } from './bills/bills.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomersComponent,
    ProductsComponent,
    NavbarComponent,
    BillsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    MatToolbarModule,
    MatIconModule,
    MatIconButton,
    MatButtonModule,
  ],
  providers: [
    provideAnimationsAsync(),
    provideHttpClient()
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
