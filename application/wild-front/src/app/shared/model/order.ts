import { Session } from './session';

export class Order {
  id: number;
  userId: number;
  sessions: Session[];
  date: Date;
  isPaid: Boolean;
  amount : number;
}
