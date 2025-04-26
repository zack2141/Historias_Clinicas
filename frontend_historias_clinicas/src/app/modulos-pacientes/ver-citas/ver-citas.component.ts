import { Component, OnInit } from '@angular/core';
import { Cita } from '../../entidades/cita';
import { PacienteService } from '../../servicios/paciente.service';
import { CitaService } from '../../servicios/cita.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { LogueosService } from '../../servicios/logueos.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ver-citas',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './ver-citas.component.html',
  styleUrl: './ver-citas.component.css'
})
export class VerCitasComponent implements OnInit {

  citas!:Cita[];

  cantcitas!: number;
  cantanteriores!:number;
  citasAnteriores: Cita[] = [];
  mostrarProximas: boolean = true;
  aside:boolean =true;

  constructor(private ServicePaciente:PacienteService,
    private Servicecita:CitaService,
     private logueoService: LogueosService,
      private router: Router
  ){}

  ngOnInit(): void {
    this.citas_proximas();
    this.SesionComoPaciente()
  }

  // funcion que muestra la barra de navegacion como paciente
  SesionComoPaciente() {
    this.logueoService.setTipoUsuario('paciente');
  }


  citas_proximas(): void {
    this.Servicecita.ver_Proximas_Citas().subscribe(data => {
      this.citas = data;
      console.log(this.citas)
      this.cantcitas = this.citas.length
    });
  }

  citas_anteriores(): void {
    this.Servicecita.ver_historial_citas().subscribe(data => {
      this.citasAnteriores = data;
      this.cantanteriores = this.citasAnteriores.length;
    });
  }

  cancelar_cita(idcita: number): void {


    Swal.fire({
      title: "¿Esta seguro de eleiminar la cita?",
      showDenyButton: true,
      showCancelButton: false,
      confirmButtonText: "Acepto",
      denyButtonText: `Cancelar`,
      allowOutsideClick:false,
      allowEscapeKey:false,
      icon: "warning"
    }).then((result) => {

      if(result.isConfirmed){

        this.Servicecita.cancelar_Cita(idcita).subscribe(() => {

      
          Swal.fire({
                      icon: 'success',
                      title: 'La cita ha sido cancelada',
                      showConfirmButton: false,
                      timer: 3000
                    }).then(() => { 
                      this.citas_proximas(); // refrescar citas
                    }); 
         
        });

      }

    })
    
  }

  ocultar_tabla_citas_proximas(): void {
    this.mostrarProximas = false;
    this.citas_anteriores();
    this.aside =false;
  }
}


