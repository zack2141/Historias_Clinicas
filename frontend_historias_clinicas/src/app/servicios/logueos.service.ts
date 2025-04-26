import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LogueosService {

  constructor() { }

  // codigo que permite ver una barra de navegacion segun quien se halla logueado
  private tipoUsuario = new BehaviorSubject<string>('ninguno');
  tipoUsuario$ = this.tipoUsuario.asObservable();

  setTipoUsuario(tipo: string) {
    this.tipoUsuario.next(tipo);
  }
}
