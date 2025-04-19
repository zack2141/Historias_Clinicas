import { Component, OnInit } from '@angular/core';
import { CitaService } from '../../servicios/cita.service';
import { MedicoService } from '../../servicios/medico.service';
import { Medico } from '../../entidades/medico';
import { Paciente } from '../../entidades/paciente';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-agendar-citas',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './agendar-citas.component.html',
  styleUrl: './agendar-citas.component.css'
})

export class AgendarCitasComponent implements OnInit {

  ngOnInit(): void {
    
  }

  constructor(private ServiceCita:CitaService,
    private ServiceMedico:MedicoService,
    
  ){}

medico!:Medico[];
med: Medico= new Medico;
paciente: Paciente = new Paciente;
fecha!:Date;
hora!:string;
motivo!:string;
cargo!:string;



solicitar_cita_paciente(){
  this.ServiceCita.agendar_cita_recep(this.fecha, this.hora, this.motivo, this.med,this.paciente).subscribe(dato=>{
    
  })
}

medico_encontrado() {
  this.ServiceMedico.listaMedicosDisponibles(this.fecha, this.hora, this.cargo).subscribe(dato => {
    this.medico = dato;
    console.log("Médicos disponibles:", this.medico);
  });
}
/*
identificacionBuscada: string = ""; // lo que escribe el usuario

  buscarPaciente() {
    if (this.identificacionBuscada.trim() === "") {
      alert("Ingrese una identificación válida");
      return;
    }

    this.ServicePaciente.buscarPacientePorIdentificacion(this.identificacionBuscada).subscribe(
      (resp: Paciente) => {
        this.paciente = resp;
      },
      err => {
        alert("Paciente no encontrado");
        this.paciente = new Paciente();
      }
    );
  }

  */
}

