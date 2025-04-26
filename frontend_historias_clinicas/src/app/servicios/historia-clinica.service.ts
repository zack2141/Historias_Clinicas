import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HistoriaClinicaService {

  private UrlBase: string = "http://localhost:8080/Ver/HistorialClinico";

  constructor(private http: HttpClient) { }

  registrarHistorial(historial: any, cita: number): Observable<any> {
    const params= new HttpParams()
    .set('idcita', cita)
    return this.http.post(`${this.UrlBase}/guardarHistorialClinico`, historial, { responseType: 'text', params });
  }

  verHistoriales(): Observable<any[]> {
    return this.http.get<any[]>(`${this.UrlBase}/ver`);
  }
}
