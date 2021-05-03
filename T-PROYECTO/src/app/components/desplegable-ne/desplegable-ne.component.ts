import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-desplegable-ne',
  templateUrl: './desplegable-ne.component.html',
  styleUrls: ['./desplegable-ne.component.css']
})
export class DesplegableNeComponent implements OnInit {

  nivelesEducativos: string[] = [];
  neSeleccionada: string = '0';

  constructor(private dataService: DataService) {
    this.nivelesEducativos = ['MAGISTER', 'PROFESIONAL', 'TECNICO', 'TECNOLOGO'];
    this.dataService.nivelesEducativosSeleccionado = "";
  }

  ngOnInit(): void {
  }

  capturar() {
    this.dataService.nivelesEducativosSeleccionado = this.neSeleccionada;
    console.log(this.dataService.nivelesEducativosSeleccionado);
  }
}
