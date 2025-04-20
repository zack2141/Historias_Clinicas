import { Observable } from 'rxjs';
import { HttpParams, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { formatDate } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  private UrlMedico: string = 'http://localhost:8080/Medico'; 

  constructor(private http: HttpClient) { }

  listaMedicosDisponibles(fecha: Date, hora: string, cargo: string): Observable<any[]> {
    const fechaFormateada = formatDate(fecha, 'dd/MM/yyyy', 'en-US');

    const params = new HttpParams()
      .set('fecha', fechaFormateada)
      .set('hora', hora)
      .set('cargo', cargo);

    return this.http.get<any[]>(`${this.UrlMedico}/medicosDisponibles`, { params });
  }

}
