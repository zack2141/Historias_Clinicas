import { FormsModule } from '@angular/forms';
import { Component } from '@angular/core';
import { LoginsService } from '../servicios/logins.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-inicio-secion',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './inicio-secion.component.html',
  styleUrls: ['./inicio-secion.component.css']
})
export class InicioSecionComponent {

  usuario: string = '';
  password: string = '';

  mostrarLogin: boolean = true;

  constructor(private loginService: LoginsService, private router: Router) {}

  iniciarSesion() {

    this.loginService.loginMedico(this.usuario, this.password).subscribe(
      res => {
        if (res !== 'usuario o contraseña incorrectos') {
          // Si el login fue exitoso como médico
          Swal.fire('¡Bienvenido!', 'Sesión iniciada como médico.', 'success').then(() => {
            this.vista_medico();
          });
        } else {
         
          this.loginService.loginPaciente(this.usuario, this.password).subscribe(
            res2 => {
              if (res2 !== 'usuario o contraseña incorrectos') {
                Swal.fire('¡Bienvenido!', 'Sesión iniciada como paciente.', 'success').then(() => {
                  this.vista_paciente();
                });
              } else {
               
                this.loginService.loginRecepcionista(this.usuario, this.password).subscribe(
                  res3 => {
                    if (res3 !== 'Credenciales incorrectas') {
                      Swal.fire('¡Bienvenido!', 'Sesión iniciada como recepcionista.', 'success').then(() => {
                        this.vista_recep();
                      });
                    } else {
                      
                      Swal.fire('Error', 'Usuario o contraseña incorrectos.', 'error');
                    }
                  }
                );
              }
            }
          );
        }
      },
      err => {
        Swal.fire('Error', 'Error al conectar con el servidor.', 'error');
      }
  );
}

  vista_medico() {
    this.mostrarLogin = false;
    this.router.navigate(['/lista-pacientes']);

  }

  vista_paciente() {
    console.log('Antes de cambiar:', this.mostrarLogin);
    this.mostrarLogin = false;
    this.router.navigate(['/ver-citas']);
    console.log('Después de cambiar:', this.mostrarLogin);
  }

  vista_recep() {
    this.mostrarLogin = false;
    this.router.navigate(['/lista-citas']);
  }


  irARegistroPaciente() {
    this.mostrarLogin = false;
    this.router.navigate(['/registro-paciente']); 
  }
}
