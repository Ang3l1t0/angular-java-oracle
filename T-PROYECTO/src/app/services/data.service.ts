import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  criterioSeleccionado: string = '';
  ciudadSeleccionada: string = '';
  edadSeleccionado: number = 0;
  estratoSeleccionado: number = 0;
  nivelesEducativosSeleccionado: string = '';
  profesionSeleccionada: string = '';
  sexoSeleccionado: string = '';
  constructor() { }
}