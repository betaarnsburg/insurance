import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrl: './search-product.component.css'
})
export class SearchProductComponent {

  comparator: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private router: Router) {
    this.comparator = this.formBuilder.group({
      age: [null, Validators.required],
      diabetics: [false],
      highBloodPressure: [false],
      travelDays: [null, Validators.required]
    })
  }

  saveComparator(){
    this.router.navigate(["/result"],
      {queryParams: {
        age: this.comparator.controls["age"].value,
        isDiabetics: this.comparator.controls["diabetics"].value,
        isHighBloodPressure: this.comparator.controls["highBloodPressure"].value,
        travelDays: this.comparator.controls["travelDays"].value,
        }});
  }

}
