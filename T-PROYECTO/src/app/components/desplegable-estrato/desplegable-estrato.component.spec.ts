import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesplegableEstratoComponent } from './desplegable-estrato.component';

describe('DesplegableEstratoComponent', () => {
  let component: DesplegableEstratoComponent;
  let fixture: ComponentFixture<DesplegableEstratoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DesplegableEstratoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DesplegableEstratoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
