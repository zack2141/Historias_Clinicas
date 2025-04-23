import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Paciente } from '../entidades/paciente';
import { Observable } from 'rxjs';
import { LoguinPaciente } from '../entidades/loguin-paciente';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  UrlPaciente: String = 'http://localhost:8080/Paciente';

  constructor(private http: HttpClient) { }

  registrar_paciente(paciente: LoguinPaciente): Observable<boolean> {


    return this.http.post<boolean>(`${this.UrlPaciente}/registrar`, paciente);
  }


  ver_Paciente(id: string): Observable<LoguinPaciente> {
    return this.http.get<LoguinPaciente>(`${this.UrlPaciente}/ObtenerPaciente?id=${id}`);
  }

  actualizar_Paciente(paciente: LoguinPaciente): Observable<boolean> {
    return this.http.post<boolean>(`${this.UrlPaciente}/ActualizarPaciente`, paciente);
  }

}
