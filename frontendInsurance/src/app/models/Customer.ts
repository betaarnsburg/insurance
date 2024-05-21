import {Product} from "./Product";
import {Order} from "./Order";

export interface Customer {
  id?: number;
  firstName: string;
  lastName: string;
  birthday: string;
  address: string;
  phone: string;
  email: string;
  gender: string;
  diabetics: boolean;
  highBloodPressure: boolean;
  product: Product;
  orders: Order[];
}
