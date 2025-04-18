import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginsService {

  private urlLogin = 'http://localhost:8080/loguin';

  constructor(private http: HttpClient) {}

  loginMedico(usuario: string, password: string) {
    const params = new HttpParams()
      .set('usuarioMedico', usuario)
      .set('passwordMedico', password);
    return this.http.get(`${this.urlLogin}/LogueoMedico`, { responseType: 'text', params });
  }

  logoutMedico() {
    return this.http.get(`${this.urlLogin}/CerrarSesionMedico`, { responseType: 'text' });
  }

  loginRecepcionista(usuario: string, password: string) {
    const params = new HttpParams()
      .set('usuarioRecep', usuario)
      .set('passwordRecep', password);
    return this.http.get(`${this.urlLogin}/Logueo`, { responseType: 'text', params });
  }

  logoutRecepcionista() {
    return this.http.get(`${this.urlLogin}/CerrarSesion`, { responseType: 'text' });
  }

  loginPaciente(usuario: string, password: string) {
    const params = new HttpParams()
      .set('usuarioPaciente', usuario)
      .set('password', password);
    return this.http.get(`${this.urlLogin}/LogueoPaciente`, { responseType: 'text', params });
  }

  logoutPaciente() {
    return this.http.get(`${this.urlLogin}/cerrarSesion`, { responseType: 'text' });
  }
}