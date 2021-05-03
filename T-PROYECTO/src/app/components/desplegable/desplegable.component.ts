import { Component, Input, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-desplegable',
  templateUrl: './desplegable.component.html',
  styleUrls: ['./desplegable.component.css']
})
export class DesplegableComponent implements OnInit {

  criterios: string[];
  opcionSeleccionada: string = '0';
  @Input() desplegable: string;

  constructor(private dataService: DataService) {
    this.criterios = ['CIUDAD', 'DATA CREDITO', 'EDAD', 'NIVEL EDUCATIVO', 'PROFESION', 'SEXO', 'ESTRATO'];
    this.dataService.criterioSeleccionado = "";
  }

  ngOnInit(): void {
  }

  capturar() {
    this.dataService.criterioSeleccionado = this.opcionSeleccionada;
    console.log(this.dataService.criterioSeleccionado);
  }
}