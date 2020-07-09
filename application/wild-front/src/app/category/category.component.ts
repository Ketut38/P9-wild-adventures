import { Component, OnInit } from "@angular/core";
import { CategoryService } from "../services/category.service";

@Component({
  selector: "app-category",
  templateUrl: "./category.component.html",
  styleUrls: ["./category.component.css"]
})
export class CategoryComponent implements OnInit {
  public allCategories: any = [];
  constructor(private categoryService: CategoryService) {}

  ngOnInit() {
    this.getAllCategories();
  }

  getAllCategories() {
    this.categoryService.getAllCategories().subscribe(res => {
      this.allCategories = res;
      console.log("getAllCategories ", this.allCategories);
    });
  }
}
