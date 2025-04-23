import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Medico } from '../entidades/medico';
import { Paciente } from '../entidades/paciente';
import { formatDate } from '@angular/common';
import { Cita } from '../entidades/cita';

@Injectable({
  providedIn: 'root'
})
export class CitaService {
  

  constructor(private httpClient: HttpClient) { 

  }

  private bdURL="http://localhost:8080/Cita"


  agendar_cita(
    fecha:Date,
    Hora:String,
    Motivo:String,
    med:number):Observable<any>{
      return this.httpClient.get(`${this.bdURL}/agendarCitaPaciente?motivo=${Motivo}&`+`Fecha=${fecha}`+
        `&hora=${Hora}`+`&medico=${med}`
      );
    }



 agendar_cita_recep(
      idmed:number,
      idpaci:number,
      motivo: string,
      fecha: Date,
      hora: string):Observable<any>{

        

        return this.httpClient.get<boolean>(`${this.bdURL}/agendarCitaRecep?`+
          `motivo=${motivo}&`+
          `Fecha=${fecha}&`+
          `hora=${hora}&`+
          `medico=${idmed}&`+
          `paciente=${idpaci}`
        );
        }



  ver_Proximas_Citas():Observable<any>{
  return this.httpClient.get(`${this.bdURL}/citasProximas`
  );
  }

  ver_historial_citas():Observable<any>{
  return this.httpClient.get(`${this.bdURL}/citasSolicitadas`)
  }

  cancelar_Cita(
    idcita:number
  ):Observable<any>{
    return this.httpClient.get(`${this.bdURL}/cancelarCita?id=${idcita}`
    );
  }

  pacientes_Cita_Medico(
    fecha: String
  ): Observable<any> {
    return this.httpClient.get(`${this.bdURL}/ListaPacientesPorFecha?fecha1=${fecha}`);
  }
  

  ingreso_Paciente(
    idcita:number
  ):Observable<any>{
    return this.httpClient.get(`${this.bdURL}/IngresoPaciente?id=${idcita}`
    );
  }

 citas_del_Dia(
  ):Observable<any>{
    return this.httpClient.get(`${this.bdURL}/citasdelDia`
    );
  }

  citas_del_Dia2(
  ):Observable<any>{
    return this.httpClient.get(`${this.bdURL}/citasdelDia2`
    );
  }

    citas_un_Dia(
      fecha:Date
    ):Observable<any>{
      return this.httpClient.get(`${this.bdURL}/citasunDia?fechai=${fecha}`
      );
    }

    citas_Paciente(
      fecha:String,
      idPaciente:number
    ):Observable<any>{
      return this.httpClient.get(`${this.bdURL}/citasPaciente?fecha1=${fecha}`+
        `&IDpaciente=${idPaciente}`)
    }

    citas_repetidas(fecha:Date):Observable<any>{
      return this.httpClient.get(`${this.bdURL}/citarepetida?Fecha=${fecha}`)

    }

}
