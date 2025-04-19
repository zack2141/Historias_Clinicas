import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HistoriaClinicaService {

  private UrlBase: string = "http://localhost:8080/Ver/HistorialClinico";

  constructor(private http: HttpClient) { }

  registrarHistorial(historial: any): Observable<any> {
    return this.http.post(`${this.UrlBase}/guardarHistorialClinico`, historial, { responseType: 'text' });
  }

  verHistoriales(): Observable<any[]> {
    return this.http.get<any[]>(`${this.UrlBase}/ver`);
  }
}
