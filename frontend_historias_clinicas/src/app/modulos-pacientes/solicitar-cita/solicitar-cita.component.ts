import { CitaService } from './../../servicios/cita.service';
import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Medico } from '../../entidades/medico';
import {Cita} from '../../entidades/cita';
import { CommonModule } from '@angular/common';
import { MedicoService } from '../../servicios/medico.service';

@Component({
  selector: 'app-solicitar-cita',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './solicitar-cita.component.html',
  styleUrl: './solicitar-cita.component.css'
})
export class SolicitarCitaComponent implements OnInit{

ngOnInit(): void{

}

constructor(private Servicecita:CitaService,
  private ServiceMedico:MedicoService
){}
/*ServicePaciente: serpa, Servicecita:serci*/
fecha!: Date;
hora!: string;
motivo!: string;
med!:Medico;
Medicos!:Medico[];
cargo!:string;






solicitar_cita_paciente() {
  console.log("Médico seleccionado:", this.med); // 👈 Agregá esto

  if (!this.med || !this.med.idMedico) {
    alert("Por favor seleccione un médico antes de confirmar.");
    return;
  }

  this.Servicecita.agendar_cita(this.fecha, this.hora, this.motivo, this.med.idMedico).subscribe(dato => {
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

}

