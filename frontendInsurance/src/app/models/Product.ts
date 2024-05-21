import {Customer} from "./Customer";
import {Order} from "./Order";

export interface Product {
  id?: number;
  name: string;
  description: string;
  price: number;
  customers: Customer[];
  orders: Order[];
}
