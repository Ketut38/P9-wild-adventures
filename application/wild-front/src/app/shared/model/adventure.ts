import { Session } from "./session";
import { Category } from "./category";

export class Adventure {
  id: number;
  title: string;
  description: string;
  nbparticipant: number;
  location: string;
  price: number;
  image: string;
  sessions: Session[];
  category_id: number;
}
