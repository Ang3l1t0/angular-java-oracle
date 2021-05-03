import { TestBed } from '@angular/core/testing';

import { SeleccionadosService } from './seleccionados.service';

describe('SeleccionadosService', () => {
  let service: SeleccionadosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeleccionadosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
