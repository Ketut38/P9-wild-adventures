import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionsByAdventureComponent } from './sessions-by-adventure.component';

describe('SessionsByAdventureComponent', () => {
  let component: SessionsByAdventureComponent;
  let fixture: ComponentFixture<SessionsByAdventureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SessionsByAdventureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SessionsByAdventureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
