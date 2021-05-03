import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CandidatosComponent } from './components/candidatos/candidatos.component';
import { CriteriosComponent } from './components/criterios/criterios.component';
import { SeleccionadosComponent } from './components/seleccionados/seleccionados.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'criterios' },
  { path: 'criterios', component: CriteriosComponent },
  { path: 'candidatos', component: CandidatosComponent },
  { path: 'candidatos/seleccion', component: SeleccionadosComponent },
  { path: '**', redirectTo: 'criterios' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
