import { CitaService } from './../../servicios/cita.service';
import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Medico } from '../../entidades/medico';
import {Cita} from '../../entidades/cita';
import { CommonModule } from '@angular/common';
import { MedicoService } from '../../servicios/medico.service';
import { LogueosService } from '../../servicios/logueos.service';
import Swal from 'sweetalert2';

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
    
    Swal.fire({
                      icon: 'warning',
                      title: 'por favor, seleccione un medico antes de agendar la cita',
                      showConfirmButton: false,
                      timer: 3000
                    })

    

    return;
  }

  this.Servicecita.agendar_cita(this.fecha, this.hora, this.motivo, this.med.idmedico).subscribe(dato => {
    if (dato) {
      Swal.fire({
        icon: 'success',
        title: 'La cita ha sido agendada ',
        showConfirmButton: true
      }).then(() => { 
        window.location.reload();; // refrescar citas
      }); 
      
    } else {
      Swal.fire({
        icon: 'success',
        title: 'fallo en la solicitud ',
        showConfirmButton: true
      }).then(() => { 
        window.location.reload();; // refrescar citas
      }); 
    }
  });
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

cita_repetida(){
  this.Servicecita.citas_repetidas(this.fecha).subscribe(dato=>{

    if(dato === true){
      Swal.fire({
        icon: 'warning',
        title: 'señor usuario, ya tiene citas agendadas para la fecha, por favor escoja otra fecha',
        showConfirmButton: true
      })
    }

  })
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

