import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Paciente } from '../entidades/paciente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  UrlPaciente: String = 'http://localhost:8080/Paciente';

  constructor(private http: HttpClient) { }

  registrar_paciente(nuevo: Paciente, usuario: string, password: string): Observable<boolean> {
    const params = new HttpParams()
      .set('usuario', usuario)
      .set('password', password);

    return this.http.post<boolean>(`${this.UrlPaciente}/registrar`, nuevo, { params });
  }

 /* buscarPacientePorIdentificacion(identificacion: string): Observable<Paciente> {
    return this.http.get<Paciente>(`${this.UrlPaciente}/pacientes/${identificacion}`);
  }*/


  ver_Paciente(id: number): Observable<Paciente> {
    return this.http.get<Paciente>(`${this.UrlPaciente}/ObtenerPaciente?id=${id}`);
  }

  actualizar_Paciente(paciente: Paciente): Observable<boolean> {
    return this.http.post<boolean>(`${this.UrlPaciente}/ActualizarPaciente`, paciente);
  }
}
