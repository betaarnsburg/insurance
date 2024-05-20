import {Customer} from "./Customer";
import {Product} from "./Product";

export interface Order {
  id?: number;
  startDate: string;
  endDate: string;
  customer: Customer;
  product: Product;
  orderDate: string;
  isPaid: boolean;
}
