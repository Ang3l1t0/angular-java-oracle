import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesplegableCiudadComponent } from './desplegable-ciudad.component';

describe('DesplegableCiudadComponent', () => {
  let component: DesplegableCiudadComponent;
  let fixture: ComponentFixture<DesplegableCiudadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DesplegableCiudadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DesplegableCiudadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
