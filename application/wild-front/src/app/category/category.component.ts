import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  public allCategories: any = [];
  public categories: any = [];
  constructor(private categoryService: CategoryService) {
    /* this.categories = [
      {
        id: 1,
        title: "Terre",
        description:
          "Randonnée ou trekking, Escalade, Spéléologie, ... Etes vous prets ?",
        image:
          "https://trek.scene7.com/is/image/TrekBicycleProducts/b300_mtbMarqueeImage?$responsive-pjpg$&cache=on,on&wid=1920"
      },
      {
        id: 2,
        title: "Eau",
        description:
          "Canyoning, Plongée sous marine, Kitesurf ... Prenez votre respiration.",
        image:
          "https://images.lesechos.fr/archives/2015/LesEchosWeekEnd/00011/ECWE00011011_1.jpg"
      },
      {
        id: 3,
        title: "Neige",
        description:
          "Cascade d eglace, Ski de randonnée, Motoneige, ... N'ayez pas froid au yeux.",
        image:
          "https://img6.onthesnow.com/image/la/99/en_montagne_neige_et_redoux_ne_99461.jpg"
      }
    ]; */
  }

  ngOnInit() {
    this.getAllCategories();
  }

  getAllCategories() {
     this.categoryService.getAllCategories().subscribe(res => {
      this.allCategories = res;
      console.log('getAllCategories ', this.allCategories);
    }); 
     this.allCategories = this.categories;
  }
}
