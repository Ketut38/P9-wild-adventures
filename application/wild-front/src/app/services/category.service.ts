import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Category } from "../shared/model/category";
import { apiCategoryById, apiCategory } from "../shared/constants";

@Injectable({
  providedIn: "root"
})
export class CategoryService {
  constructor(private http: HttpClient) {}

  getAllCategories() {
    return this.http.get(apiCategory);
  }
  getCategoryById(id: number): Observable<Category> {
    return this.http.get<Category>(apiCategoryById + "/" + id);
  }
}
