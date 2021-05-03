import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesplegableEdadComponent } from './desplegable-edad.component';

describe('DesplegableEdadComponent', () => {
  let component: DesplegableEdadComponent;
  let fixture: ComponentFixture<DesplegableEdadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DesplegableEdadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DesplegableEdadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
