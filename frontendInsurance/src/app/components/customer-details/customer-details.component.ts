import { Component } from '@angular/core';
import {Customer} from "../../models/Customer";
import {CustomerService} from "../../services/customer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrl: './customer-details.component.css'
})
export class CustomerDetailsComponent {
  customerDetails?: Customer;
  constructor(private customerService: CustomerService,
              private activatedRoute:ActivatedRoute,
              private router: Router) {
    const id = this.activatedRoute.snapshot.paramMap.get("id");
    if (id){
      this.customerService.getCustomerById(parseInt(id)).subscribe(
        data => this.customerDetails = data
      )
    }
  }

  deleteCustomer(id: number){
    this.customerService.deleteCustomer(id).subscribe(
      () => this.router.navigate(["/customers"])
    );
  }

}
