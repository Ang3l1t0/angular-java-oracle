import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-desplegable-ciudad',
  templateUrl: './desplegable-ciudad.component.html',
  styleUrls: ['./desplegable-ciudad.component.css']
})
export class DesplegableCiudadComponent implements OnInit {

  ciudades: string[] = [];
  ciudadSeleccionada: string = '0';

  constructor(private dataService: DataService) {
    this.ciudades = ['BARRANQUILLA', 'BOGOTA', 'BUCARAMANGA', 'CARTAGENA', 'CALI', 'CUCUTA', 'LETICIA', 'MEDELLIN'];
    this.dataService.ciudadSeleccionada = "";
  }

  ngOnInit(): void {
  }

  capturar() {
    this.dataService.ciudadSeleccionada = this.ciudadSeleccionada;
    console.log(this.dataService.ciudadSeleccionada);
  }
}
