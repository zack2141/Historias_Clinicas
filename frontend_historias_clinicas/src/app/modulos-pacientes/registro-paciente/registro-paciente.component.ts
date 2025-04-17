import { Component } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


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

  constructor(private http: HttpClient) {}

  registrar() {
    const params = new HttpParams()
      .set('usuario', this.usuario)
      .set('password', this.password);

    this.http.post<boolean>('http://localhost:8080/registrar', this.paciente, { params })
      .subscribe({
        next: respuesta => {
          if (respuesta) {
            alert('Registro exitoso');
          } else {
            alert('Error al registrar');
          }
        },
        error: () => alert('Error al conectar con el servidor')
      });
  }
}


