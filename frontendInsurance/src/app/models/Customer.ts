import {Product} from "./Product";
import {Order} from "./Order";

export interface Customer {
  id?: number;
  firstName: string;
  lastName: string;
  birthDate: string;
  address: string;
  phone: string;
  email: string;
  gender: string;
  isDiabetics: boolean;
  isHighBloodPressure: boolean;
  product: Product;
  orders: Order[];
}
