import { Medico } from './medico';
import { Paciente } from './paciente';

export class HistorialClinico {

  idHistorial !:number
  diagnostico !:String
  observaciones !:String
  motivo !:String
  enfermedadPaciente !:String
  tratamientos !:String
  recetaMedicamentos !:String
  examenesComplementarios !:String
  idPaciente !:Paciente
  idMedico !:Medico
  motivoCita !:String

}
