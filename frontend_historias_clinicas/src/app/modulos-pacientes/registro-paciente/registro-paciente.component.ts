import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { PacienteService } from '../../servicios/paciente.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-registro-paciente',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './registro-paciente.component.html',
  styleUrl: './registro-paciente.component.css'
})
export class RegistroPacienteComponent {

  paciente: any = {};
  usuario: string = '';
  password: string = '';

  constructor(private serpa: PacienteService, private router: Router) {}

registrar() {
  this.serpa.registrar_paciente(this.paciente, this.usuario, this.password)
    .subscribe({
      next: (respuesta) => {
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
      error: () => {
        Swal.fire({
          icon: 'error',
          title: 'Error de conexión',
          text: 'No se pudo conectar con el servidor.'
        });
      }
    });
}

  
}
