import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SearchProductComponent} from "./components/search-product/search-product.component";
import {ResultComponent} from "./components/result/result.component";
import {CustomerFormComponent} from "./components/customer-form/customer-form.component";
import {CustomersComponent} from "./components/customers/customers.component";
import {CustomerDetailsComponent} from "./components/customer-details/customer-details.component";

const routes: Routes = [
  {path:"search", component: SearchProductComponent},
  {path:"result", component: ResultComponent},
  {path:"customerForm", component: CustomerFormComponent},
  {path:"customerForm/:id", component: CustomerFormComponent},
  {path:"customers", component: CustomersComponent},
  {path:"customer/:id", component: CustomerDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
