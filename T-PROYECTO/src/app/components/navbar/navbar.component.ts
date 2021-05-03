import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  tituloProyecto: string;
  subtitulo1: string;
  subtitulo2: string;

  constructor() {
    this.tituloProyecto = 'T-PROYECTO';
    this.subtitulo1 = 'CRITERIOS';
    this.subtitulo2 = 'CANDIDATOS';
  }

  ngOnInit(): void {
  }

}
