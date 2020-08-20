import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Category } from "../shared/model/category";
import { apiCategoryById, apiCategory, apidAdventure } from "../shared/constants";
import { Adventure } from '../shared/model/adventure';

@Injectable({
  providedIn: "root"
})
export class CategoryService {
  constructor(private http: HttpClient) {}

  getAllCategories() {
    return this.http.get(apiCategory);
  }
  getCategoryById(id: number): Observable<Category> {
    return this.http.get<Category>(apiCategoryById + "/category/" + id);
  }

  getAdventuresByCatId(id: number): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(apidAdventure + "/category/" + id);
  }
}
