import { CitaService } from './../../servicios/cita.service';
import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Medico } from '../../entidades/medico';
import {Cita} from '../../entidades/cita';
import { CommonModule } from '@angular/common';
import { MedicoService } from '../../servicios/medico.service';
import { LogueosService } from '../../servicios/logueos.service';

@Component({
  selector: 'app-solicitar-cita',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './solicitar-cita.component.html',
  styleUrl: './solicitar-cita.component.css'
})
export class SolicitarCitaComponent implements OnInit{



constructor(private Servicecita:CitaService,
  private ServiceMedico:MedicoService,
  private logueoService: LogueosService
){}

ngOnInit(): void{

  this.SesionComoPaciente()
}

// funcion que muestra la barra de navegacion como paciente
SesionComoPaciente() {
  this.logueoService.setTipoUsuario('paciente');
}
/*ServicePaciente: serpa, Servicecita:serci*/
fecha!: Date;
hora!: string;
motivo!: string;
med : Medico= new Medico;
Medicos!:Medico[];
cargo!:string;

medicoSelccionado !: Medico;






solicitar_cita_paciente() {
  console.log("Médico seleccionado:", this.med); // 👈 Agregá esto


  if (!this.med || !this.med.idmedico) {
    alert("Por favor seleccione un médico antes de confirmar.");
    return;
  }

  this.Servicecita.agendar_cita(this.fecha, this.hora, this.motivo, this.med.idmedico).subscribe(dato => {
    if (dato) {
      alert("Cita Agendada");
      window.location.reload();
    } else {
      alert("La solicitud ha fallado");
    }
  });
}

medico_encontrado() {
  this.ServiceMedico.listaMedicosDisponibles(this.fecha, this.hora, this.cargo).subscribe(dato => {
    this.Medicos = dato;
    console.log("Médicos disponibles:", this.Medicos);
  });

  
  
}

/*
medicoSelect(id:number){

  var filtro = this.Medicos.find(buscado => buscado.idMedico === id)

if (filtro){

  this.medicoSelccionado= filtro;

  console.log("medico seleccionado")

}

  
}*/

}

