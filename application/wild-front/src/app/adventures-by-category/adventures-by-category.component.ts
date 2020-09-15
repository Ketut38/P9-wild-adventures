import { Component, OnInit } from '@angular/core';
import { Adventure } from '../shared/model/adventure';
import { Category } from '../shared/model/category';
import { AdventureService } from '../services/adventure.service';
import { CategoryService } from '../services/category.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-adventures-by-category',
  templateUrl: './adventures-by-category.component.html',
  styleUrls: ['./adventures-by-category.component.css']
})
export class AdventuresByCategoryComponent implements OnInit {

  private adventuresByCategory: Adventure[] = [];
  category: Category = {  id: null, title: '', description : '', image: '', adventures:[]};
  constructor(private adventureService:AdventureService,private categoryService:CategoryService, private route: ActivatedRoute) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.getCategoryById(id);
    this.getAventuresByCategory(id);

  }

  getCategoryById(id:number){
    return this.categoryService.getCategoryById(id).subscribe((res)=>{
      console.log("category", res);
      this.category = res;
    })
  }

  getAventuresByCategory(id:number){
    return this.categoryService.getAdventuresByCatId(id).subscribe((res) => {
      this.adventuresByCategory = res;
    });
  }



}
