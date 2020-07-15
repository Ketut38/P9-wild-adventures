import { Adventure } from "./adventure";

export class Category {
  id: number;
  title: string;
  description: string;
  image: string;
  adventures: Adventure[];
}
