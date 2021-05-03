import { Component, OnInit } from '@angular/core';
import { Candidatos } from './candidatos';
import { CandidatosService } from '../../services/candidatos.service';

@Component({
  selector: 'app-candidatos',
  templateUrl: './candidatos.component.html',
  styleUrls: ['./candidatos.component.css']
})
export class CandidatosComponent implements OnInit {

  p: number = 1;
  candidatos: Candidatos[];

  constructor(private candidatosService: CandidatosService) { }

  ngOnInit(): void {
    this.candidatosService.getAll().subscribe(
      c => this.candidatos = c
    );
  }
}
