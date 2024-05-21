import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ComparatorService} from "../../services/comparator.service";
import {Product} from "../../models/Product";

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrl: './result.component.css'
})
export class ResultComponent {

  product?: Product;

  constructor(private route: ActivatedRoute,
              private comparatorService: ComparatorService) {
    this.comparatorService.recommendProduct(
      parseInt(this.route.snapshot.queryParamMap.get("age")!),
      this.route.snapshot.queryParamMap.get("diabetics")!,
      this.route.snapshot.queryParamMap.get("highBloodPressure")!,
      parseInt(this.route.snapshot.queryParamMap.get("travelDays")!)
    ).subscribe(product => this.product = product);
  }

}
