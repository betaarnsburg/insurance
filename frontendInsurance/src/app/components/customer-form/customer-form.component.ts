import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Product} from "../../models/Product";
import {ProductService} from "../../services/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrl: './customer-form.component.css'
})
export class CustomerFormComponent {
  saveCustomer: FormGroup;
  products: Product[] = [];
  constructor(private formBuilder: FormBuilder,
              private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private router: Router) {
    this.productService.getAllProducts().subscribe(products => this.products = products);

    this.saveCustomer = this.formBuilder.group({
      firstName: [null, Validators.required],
      lastName: [null, Validators.required],
      birthDate: [null, Validators.required],
      address: [null, Validators.required],
      phone: [null, Validators.required],
      email: [null, Validators.required],
      gender: [null, Validators.required],
      isDiabetics: [false],
      isHighBloodPressure: [false],
      product: [null, Validators.required]
    });
    const id = this.activatedRoute.snapshot.paramMap.get("id");
    if(id){
      customerService.getCustomerById(parseInt(id))
        .subscribe(customer => this.saveCustomer.patchValue(customer));
    }

  }

  compareProduct(p1: Product, p2: Product) {
    return p1.id === p2.id;
  }

  submitForm(){
    if(this.saveCustomer.value.id){
      this.customerService.updateCustomer(this.saveCustomer.value).subscribe(
        () => this.router.navigate(["/customers"]));
    }else {
      this.customerService.creatCustomer(this.saveCustomer.value).subscribe(
        () => this.router.navigate(["/customers"])
      )
    }
  }

}
