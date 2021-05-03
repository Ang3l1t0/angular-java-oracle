import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-desplegable-estrato',
  templateUrl: './desplegable-estrato.component.html',
  styleUrls: ['./desplegable-estrato.component.css']
})
export class DesplegableEstratoComponent implements OnInit {

  estratos: number[];
  estratoSeleccionada: number = 0;

  constructor(private dataService: DataService) {
    this.estratos = new Array(6).fill(0).map((x, i) =>i + 1);
  }

  ngOnInit(): void {
  }

  capturar() {
    this.dataService.estratoSeleccionado = this.estratoSeleccionada;
    console.log(this.dataService.estratoSeleccionado);
  }

}
