import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesplegableProfesionComponent } from './desplegable-profesion.component';

describe('DesplegableProfesionComponent', () => {
  let component: DesplegableProfesionComponent;
  let fixture: ComponentFixture<DesplegableProfesionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DesplegableProfesionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DesplegableProfesionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
