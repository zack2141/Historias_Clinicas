import { Paciente } from "./paciente"
import { Medico } from "./medico"

export class Cita {
idcita!:number
hora!:String
fecha!:Date
idmedico!:Medico
idpaciente!:Paciente
motivoCita !: String
idrecepcionista!: null

}
