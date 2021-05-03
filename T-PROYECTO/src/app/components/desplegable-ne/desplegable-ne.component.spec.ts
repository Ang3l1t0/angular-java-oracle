import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesplegableNeComponent } from './desplegable-ne.component';

describe('DesplegableNeComponent', () => {
  let component: DesplegableNeComponent;
  let fixture: ComponentFixture<DesplegableNeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DesplegableNeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DesplegableNeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
