import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesplegableDataCreditoComponent } from './desplegable-data-credito.component';

describe('DesplegableDataCreditoComponent', () => {
  let component: DesplegableDataCreditoComponent;
  let fixture: ComponentFixture<DesplegableDataCreditoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DesplegableDataCreditoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DesplegableDataCreditoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
