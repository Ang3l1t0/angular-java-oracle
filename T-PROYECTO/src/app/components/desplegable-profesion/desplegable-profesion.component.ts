import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-desplegable-profesion',
  templateUrl: './desplegable-profesion.component.html',
  styleUrls: ['./desplegable-profesion.component.css']
})
export class DesplegableProfesionComponent implements OnInit {

  profesiones: string[] = [];
  profesionSeleccionada: string = '0';

  constructor(private dataService: DataService) {
    this.profesiones = ['ELECTRONICO', 'SISTEMAS', 'CONTADURIA', 'ADMINISTRACION', 'MECANICO', 'INDUSTRIAL', 'DERECHO'];
    this.dataService.profesionSeleccionada = "";
  }

  ngOnInit(): void {
  }

  capturar() {
    this.dataService.profesionSeleccionada = this.profesionSeleccionada;
    console.log(this.dataService.profesionSeleccionada);
  }
}
