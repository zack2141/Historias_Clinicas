import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginsService {

  private urlLogin = 'http://localhost:8080/Loguin';

  constructor(private http: HttpClient) {}

  loginMedico(usuario: string, password: string): Observable<string> {
    const params = new HttpParams()
      .set('usuarioMedico', usuario)
      .set('passwordMedico', password);
    return this.http.get(`${this.urlLogin}/LogueoMedico`, { responseType: 'text', params });
  }

  loginPaciente(usuario: string, password: string): Observable<string> {
    const params = new HttpParams()
      .set('usuarioPaciente', usuario)
      .set('password', password);
    return this.http.get(`${this.urlLogin}/LogueoPaciente`, { responseType: 'text', params });
  }

  loginRecepcionista(usuario: string, password: string): Observable<string> {
    const params = new HttpParams()
      .set('usuarioRecep', usuario)
      .set('passwordRecep', password);
    return this.http.get(`${this.urlLogin}/LogueoRecepcionista`, { responseType: 'text', params });
  }

  logoutMedico() {
    return this.http.get(`${this.urlLogin}/CerrarSesionMedico`, { responseType: 'text' });
  }

  logoutRecepcionista() {
    return this.http.get(`${this.urlLogin}/CerrarSesion`, { responseType: 'text' });
  }

  logoutPaciente() {
    return this.http.get(`${this.urlLogin}/cerrarSesion`, { responseType: 'text' });
  }

  loginGeneral(usuario: string, password: string): Observable<{ tipo: string, rol: string }> {
    return this.loginMedico(usuario, password).pipe(
      switchMap(res => {
        if (res !== 'usuario o contraseña incorrectos') {
          return of({ tipo: 'medico', rol: res });
        }
        return this.loginPaciente(usuario, password).pipe(
          switchMap(res2 => {
            if (res2 !== 'usuario o contraseña incorrectos') {
              return of({ tipo: 'paciente', rol: res2 });
            }
            return this.loginRecepcionista(usuario, password).pipe(
              switchMap(res3 => {
                if (res3 !== 'Credenciales incorrectas') {
                  return of({ tipo: 'recepcionista', rol: res3 });
                }
                return of({ tipo: 'error', rol: '' });
              })
            );
          })
        );
      })
    );
  }

  obtenerPaciente(): Observable<any>{

    return this.http.get(`${this.urlLogin}/obtener`);
  }

}
