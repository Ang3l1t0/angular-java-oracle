import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-desplegable-sexo',
  templateUrl: './desplegable-sexo.component.html',
  styleUrls: ['./desplegable-sexo.component.css']
})
export class DesplegableSexoComponent implements OnInit {

  sexos: string[] = [];
  sexoSeleccionado: string = '0';

  constructor(private dataService: DataService) {
    this.sexos = ['F', 'M'];
    this.dataService.sexoSeleccionado = "";
  }

  ngOnInit(): void {
  }

  capturar() {
    this.dataService.sexoSeleccionado = this.sexoSeleccionado;
    console.log(this.dataService.sexoSeleccionado);
  }
}
