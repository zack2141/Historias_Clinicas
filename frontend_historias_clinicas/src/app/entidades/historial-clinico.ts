import { Medico } from './medico';
import { Paciente } from './paciente';

export class HistorialClinico {

  idHistorial !:number
  diagnosticos !:String
  observaciones !:String
  enfermedadPaciente !:String
  tratamientos !:String
  recetaMedicamentos !:String
  examenesComplementario !:String
  idpaciente !:Paciente | null
  idmedico !:Medico |null
  motivoCita !:String

}
