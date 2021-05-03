import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { CandidatosComponent } from './components/candidatos/candidatos.component';
import { CriteriosComponent } from './components/criterios/criterios.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DesplegableComponent } from './components/desplegable/desplegable.component';
import { DesplegableCiudadComponent } from './components/desplegable-ciudad/desplegable-ciudad.component';
import { DesplegableEstratoComponent } from './components/desplegable-estrato/desplegable-estrato.component';
import { DesplegableEdadComponent } from './components/desplegable-edad/desplegable-edad.component';
import { DesplegableNeComponent } from './components/desplegable-ne/desplegable-ne.component';
import { DesplegableSexoComponent } from './components/desplegable-sexo/desplegable-sexo.component';
import { DesplegableProfesionComponent } from './components/desplegable-profesion/desplegable-profesion.component';
import { DesplegableDataCreditoComponent } from './components/desplegable-data-credito/desplegable-data-credito.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { SeleccionadosComponent } from './components/seleccionados/seleccionados.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    CandidatosComponent,
    CriteriosComponent,
    DesplegableComponent,
    DesplegableCiudadComponent,
    DesplegableEstratoComponent,
    DesplegableEdadComponent,
    DesplegableNeComponent,
    DesplegableSexoComponent,
    DesplegableProfesionComponent,
    DesplegableDataCreditoComponent,
    SeleccionadosComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }