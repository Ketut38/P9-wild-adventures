import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdventuresByCategoryComponent } from './adventures-by-category.component';

describe('AdventuresByCategoryComponent', () => {
  let component: AdventuresByCategoryComponent;
  let fixture: ComponentFixture<AdventuresByCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdventuresByCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdventuresByCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
