
import { Component } from '@angular/core';
import { BarraNavegacionFooterComponent } from './barra-navegacion-footer/barra-navegacion-footer.component';
import { RegistroPacienteComponent } from './modulos-pacientes/registro-paciente/registro-paciente.component';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [BarraNavegacionFooterComponent, RegistroPacienteComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend_historias_clinicas';
}
