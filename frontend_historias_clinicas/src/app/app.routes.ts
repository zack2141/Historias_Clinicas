import { Routes } from '@angular/router';
import { InicioSecionComponent } from './inicio-secion/inicio-secion.component';
import { HistoriaClinicaComponent } from './modulos-medico/historia-clinica/historia-clinica.component';
import { ListaPacientesComponent } from './modulos-medico/lista-pacientes/lista-pacientes.component';
import { ActualizarPacienteComponent } from './modulos-pacientes/actualizar-paciente/actualizar-paciente.component';
import { RegistroPacienteComponent } from './modulos-pacientes/registro-paciente/registro-paciente.component';
import { SolicitarCitaComponent } from './modulos-pacientes/solicitar-cita/solicitar-cita.component';
import { VerCitasComponent } from './modulos-pacientes/ver-citas/ver-citas.component';
import { AgendarCitasComponent } from './modulos-recepcionista/agendar-citas/agendar-citas.component';
import { ListaCitasComponent } from './modulos-recepcionista/lista-citas/lista-citas.component';

export const routes: Routes = [

    // ruta para el inicio de sesion
    { path: '', redirectTo: 'inicio-sesion', pathMatch: 'full' },
    {path: 'inicio-sesion', component:InicioSecionComponent},

    // rutas del medcio
    {path: 'historia-clinica', component:HistoriaClinicaComponent},
    {path: 'lista-pacientes', component:ListaPacientesComponent},

    //rutas del paciente
    {path: 'actualizar-paciente', component:ActualizarPacienteComponent},
    {path: 'registro-paciente', component:RegistroPacienteComponent},
    {path: 'solicitar-cita', component:SolicitarCitaComponent},
    {path: 'ver-citas', component:VerCitasComponent},

    //rutas recepcionista
    {path: 'agendar-citas', component:AgendarCitasComponent},
    {path: 'lista-citas', component:ListaCitasComponent},
];
