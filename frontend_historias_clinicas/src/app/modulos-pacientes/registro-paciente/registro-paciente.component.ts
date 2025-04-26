import { Component, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { PacienteService } from '../../servicios/paciente.service';
import { Router } from '@angular/router';
import { LogueosService } from '../../servicios/logueos.service';
import { LoguinPaciente } from '../../entidades/loguin-paciente';
import { CommonModule } from '@angular/common';
import { Paciente } from '../../entidades/paciente';


@Component({
  selector: 'app-registro-paciente',
  standalone: true,
  imports: [ CommonModule, FormsModule],
  templateUrl: './registro-paciente.component.html',
  styleUrl: './registro-paciente.component.css'
})
export class RegistroPacienteComponent {


  paciente: LoguinPaciente = {
    usuarioPaciente: '',
    password: '',
    idpaciente: {
      idpaciente: 0,
      nombres: '',
      apellidos: '',
      sexo: '',
      estadoCivil: '',
      fechaNacimiento: new Date(),
      rolPaciente: '',
      direccion: '',
      rh: '',
      correo: '',
      telefono: '',
      afiliacion: ''
    }
  };

  constructor(private serpa: PacienteService, private router: Router) {}

  // funcion que muestra la barra de navegacion como paciente
 

registrar() {
  this.serpa.registrar_paciente(this.paciente)
    .subscribe(respuesta => {

      console.log(respuesta)
        if (respuesta) {
          Swal.fire({
            icon: 'success',
            title: 'Registro exitoso',
            showConfirmButton: false,
            timer: 2000
          }).then(() => {
            this.router.navigate(['/inicio-sesion']); 
          }); 
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Error al registrar',
            text: 'No se pudo completar el registro.'
          });
        }
      },
      error => {
        Swal.fire({
          icon: 'error',
          title: 'Error de conexión',
          text: 'No se pudo conectar con el servidor.'
        });
      });
}

  
}
