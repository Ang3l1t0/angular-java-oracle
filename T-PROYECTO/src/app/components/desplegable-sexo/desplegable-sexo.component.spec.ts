import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesplegableSexoComponent } from './desplegable-sexo.component';

describe('DesplegableSexoComponent', () => {
  let component: DesplegableSexoComponent;
  let fixture: ComponentFixture<DesplegableSexoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DesplegableSexoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DesplegableSexoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
