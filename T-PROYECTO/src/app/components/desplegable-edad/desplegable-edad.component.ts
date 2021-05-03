import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-desplegable-edad',
  templateUrl: './desplegable-edad.component.html',
  styleUrls: ['./desplegable-edad.component.css']
})
export class DesplegableEdadComponent implements OnInit {

  edades: number[];
  opcionSeleccionada: number = 0;

  constructor(private dataService: DataService) {
    this.edades = new Array(100).fill(0).map((x, i) =>i + 1);
  }

  ngOnInit(): void {
  }

  capturar() {
    this.dataService.edadSeleccionado = this.opcionSeleccionada;
    console.log(this.dataService.edadSeleccionado);
  }
}
