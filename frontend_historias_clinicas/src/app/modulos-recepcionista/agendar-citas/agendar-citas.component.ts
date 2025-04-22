import { Component, OnInit } from '@angular/core';
import { CitaService } from '../../servicios/cita.service';
import { MedicoService } from '../../servicios/medico.service';
import { Medico } from '../../entidades/medico';
import { Paciente } from '../../entidades/paciente';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { LogueosService } from '../../servicios/logueos.service';
import Swal from 'sweetalert2';
import { PacienteService } from '../../servicios/paciente.service';
import { Cita } from '../../entidades/cita';

@Component({
  selector: 'app-agendar-citas',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './agendar-citas.component.html',
  styleUrl: './agendar-citas.component.css'
})

export class AgendarCitasComponent implements OnInit {

  ngOnInit(): void {

    this.sesionComoRecep()
    
  }

  constructor(private ServiceCita:CitaService,
    private ServiceMedico:MedicoService,
    private logueoService: LogueosService,
    private serviciopaciente: PacienteService
        
    
  ){}

Medicos!:Medico[];
med: Medico= new Medico;
paciente: Paciente = new Paciente;
fecha!:Date;
hora!:string;
motivo!:string;
cargo!:string;

idpaciente!:number


solicitudCita: Cita = {
  idcita: 0,
  hora: '',
  fecha: new Date(),
  idmedico: this.med,
  idpaciente: this.paciente,
  motivoCita: '',
  idrecepcionista: null
};


paciente_encontrado(){
  this.serviciopaciente.ver_Paciente(this.idpaciente).subscribe(dato=>{

    if(!dato){

      Swal.fire({
        icon: 'warning',
        title: 'El ID no se encuentra registrado en el sistema',
        showConfirmButton: true
      })

    }else{
      this.paciente=dato
    }

  })
}
medico_encontrado() {
  this.ServiceMedico.listaMedicosDisponibles(this.fecha, this.hora, this.cargo).subscribe(dato => {
    this.Medicos = dato;
    console.log("Médicos disponibles:", this.Medicos);

    if(this.Medicos.length===0){
      Swal.fire({
        icon: 'warning',
        title: 'no hay medicos disponibles',
        showConfirmButton: true
      })
    }
  });

  
  
}

sesionComoRecep(){

  this.logueoService.setTipoUsuario('recep');
}

solicitar_cita_paciente(){

  this.solicitudCita.idpaciente= this.paciente
  this.solicitudCita.idmedico= this.med
  this.solicitudCita.fecha= this.fecha
  this.solicitudCita.motivoCita = this.motivo
  this.solicitudCita.hora = this.hora

  console.log(this.solicitudCita)

  this.ServiceCita.agendar_cita_recep(this.solicitudCita).subscribe(dato=>{
    if(dato === true){
      Swal.fire({
        icon: 'success',
        title: 'Solicitud realizada con exito',
        showConfirmButton: true
      }).then(()=>{
        window.location.reload()
      })
    }else{
      Swal.fire({
        icon: 'error',
        title: 'Error al procesar la solicitud',
        showConfirmButton: true
      })
    }
    
  },error=>{
    Swal.fire({
      icon: 'error',
      title: 'Error del servidor',
      showConfirmButton: true
    })
    console.warn(error)
  })

}

}

