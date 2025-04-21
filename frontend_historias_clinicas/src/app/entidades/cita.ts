import { Paciente } from "./paciente"
import { Medico } from "./medico"

export class Cita {
idCita!:number
hora!:String
fecha!:Date
motivo!:String
idMedico!:Medico
idPaciente!:Paciente
motivoCita !: string

}
