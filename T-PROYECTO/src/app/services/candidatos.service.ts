import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Candidatos } from '../components/candidatos/candidatos';

@Injectable({
  providedIn: 'root'
})
export class CandidatosService {

  private url: string = "http://localhost:8080/candidatos";

  constructor(private http: HttpClient) { }

  //Obtener datos de todos los candidatos
  getAll(): Observable<Candidatos[]> {
    return this.http.get<Candidatos[]>(this.url);
  }
}
