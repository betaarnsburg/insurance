import { Component } from '@angular/core';
import {Customer} from "../../models/Customer";
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent {
  customers: Customer[] = [];

  constructor(private customerService: CustomerService) {
    this.customerService.getAllCustomers().subscribe(
      customers => this.customers = customers
    );
  }

}
