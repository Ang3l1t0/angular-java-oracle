import { Component, OnInit } from '@angular/core';
import { SeleccionadosService } from 'src/app/services/seleccionados.service';
import { Seleccionados } from './seleccionados';

@Component({
  selector: 'app-seleccionados',
  templateUrl: './seleccionados.component.html',
  styleUrls: ['./seleccionados.component.css']
})
export class SeleccionadosComponent implements OnInit {

  p: number = 1;
  seleccionados: Seleccionados[];

  constructor(private seleccionadosService: SeleccionadosService) { }

  ngOnInit(): void {
    this.seleccionadosService.getAll().subscribe(
      s => this.seleccionados = s
    );
  }
  //************************************************************* */

  download() {
    this.seleccionadosService.downloadFile(this.seleccionados, 'InformeSeleccionados');
  }
}
