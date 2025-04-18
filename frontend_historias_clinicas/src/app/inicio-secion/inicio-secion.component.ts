import { FormsModule } from '@angular/forms';
import { Component } from '@angular/core';
import { LoginsService } from '../servicios/logins.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inicio-secion',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './inicio-secion.component.html',
  styleUrls: ['./inicio-secion.component.css']
})
export class InicioSecionComponent {

  tipoUsuario: string = '';
  usuario: string = '';
  password: string = '';
  mensaje: string = '';

  constructor(private loginService: LoginsService, private router: Router) {}

  iniciarSesion() {
    this.validar();
  }

  validar() {
    switch (this.tipoUsuario) {
      case 'medico':
        this.medico_sesion(this.usuario, this.password);
        break;
      case 'paciente':
        this.paciente_sesion(this.usuario, this.password);
        break;
      case 'recepcionista':
        this.recep_sesion(this.usuario, this.password);
        break;
    }
  }

  medico_sesion(usuario: string, password: string) {
    this.loginService.loginMedico(usuario, password).subscribe(
      res => {
        this.mensaje = res;
        if (res === 'ok') this.vista_medico();
      },
      err => this.mensaje = 'error al iniciar sesion como medico'
    );
  }

  paciente_sesion(usuario: string, password: string) {
    this.loginService.loginPaciente(usuario, password).subscribe(
      res => {
        this.mensaje = res;
        if (res === 'ok') this.vista_paciente();
      },
      err => this.mensaje = 'error al iniciar sesion como paciente'
    );
  }

  recep_sesion(usuario: string, password: string) {
    this.loginService.loginRecepcionista(usuario, password).subscribe(
      res => {
        this.mensaje = res;
        if (res === 'ok') this.vista_recep();
      },
      err => this.mensaje = 'error al iniciar sesión como recepcionista'
    );
  }

  vista_medico() {
    this.router.navigate(['/vista-medico']);
  }

  vista_paciente() {
    this.router.navigate(['/vista-paciente']);
  }

  vista_recep() {
    this.router.navigate(['/vista-recepcionista']);
  }
}
