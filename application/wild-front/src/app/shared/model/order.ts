import { OrderSession } from './order-session';

export class Order {
  id: number;
  userId: string;
  orderSessions: OrderSession[];
  date: Date;
  isPaid: Boolean;
  amount : number;
}