import { Component, OnInit } from '@angular/core';
import { Cita } from '../../entidades/cita';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CitaService } from '../../servicios/cita.service';
import { Router } from '@angular/router';

import Swal from 'sweetalert2';
import { LogueosService } from '../../servicios/logueos.service';

@Component({
  selector: 'app-lista-citas',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './lista-citas.component.html',
  styleUrl: './lista-citas.component.css'
})
export class ListaCitasComponent implements OnInit{

  lista_citas: Cita[] = [];
  fechaSeleccionada: string = '';
  idPaciente!: String;
  
  citaselect: Cita = {
      idcita: 0,
      hora: '',
      fecha: new Date(),
      motivo: '',
      motivoCita: '',
      idmedico: {
        idmedico: 0,
        residenciaMedico: '',
        telefonoMedico: '',
        direccionMedico: '',
        salarioMedcio: 0,
        correoMedico: '',
        cargoMedico: '',
        turnomedico: '',
        apellidosMedico: '',
        nombreMedico: '',
        edadMedico: ''
      },
      idpaciente: {
        idPaciente: '',
        nombres: '',
        apellidos: '',
        sexo: '',
        estadoCivil: '',
        fechaNacimiento: new Date(),
        rolPaciente: '',
        direccion: '',
        rh: '',
        correo: '',
        telefono: '',
        afiliacion: ''
      }
  };

  ngOnInit(): void {
    this.lista_dia()

    
  }

    constructor(
        private servicioCitas: CitaService,
        private router: Router,
        private logueoService: LogueosService
      ) {}

    lista_dia(){

      this.servicioCitas.citas_del_Dia().subscribe(dato =>{
        this.lista_citas= dato
      })
    }

    buscarPaciente(){
    }

    registro_ingreso(idcita:number){

      this.servicioCitas.ingreso_Paciente(idcita).subscribe(dato =>{

        if(dato == true){

          Swal.fire('Ingreso del paciente realizado', '', 'success').then(()=>{

            window.location.reload()
          });
        }

      })

    }

    
}
