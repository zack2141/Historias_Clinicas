import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Cita } from '../../entidades/cita';

import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { CitaService } from '../../servicios/cita.service';
import { LogueosService } from '../../servicios/logueos.service';

@Component({
  selector: 'app-lista-pacientes',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './lista-pacientes.component.html',
  styleUrl: './lista-pacientes.component.css'
})
export class ListaPacientesComponent implements OnInit{

  lista_citas: Cita[] = [];
  fechaSeleccionada: string = '';

  citaselect: Cita = {
    idcita: 0,
    hora: '',
    fecha: new Date(),
    motivoCita: '',
    idrecepcionista:null,
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
      idpaciente: 0,
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

  constructor(
    private servicioCitas: CitaService,
    private router: Router,
    private logueoService: LogueosService
  ) {}

  ngOnInit(): void {
    const hoy = new Date();
    this.fechaSeleccionada = hoy.toISOString().split('T')[0];
    this.lista_dia()
    this.SesionComomedico()
  }

 

  ver_lista_pacientes(): void {
    if (!this.fechaSeleccionada) {
      Swal.fire('Advertencia', 'Por favor selecciona una fecha.', 'warning');
      return;
    }

    const fecha = new Date(this.fechaSeleccionada);
    const dia = String(fecha.getDate()).padStart(2, '0');
    const mes = String(fecha.getMonth() + 1).padStart(2, '0');
    const anio = fecha.getFullYear();
    const fechaFormateada = `${dia}/${mes}/${anio}`; // Formato correcto para el backend

    console.log('Fecha seleccionada:', this.fechaSeleccionada);
    console.log('Fecha formateada para enviar al backend:', fechaFormateada);

    Swal.fire({
      title: 'Buscando pacientes...',
      didOpen: () => {
        Swal.showLoading();
      },
      allowOutsideClick: false
    });

    this.servicioCitas.pacientes_Cita_Medico(this.fechaSeleccionada).subscribe(
      (data: Cita[]) => {
        Swal.close();
        this.lista_citas = data;

        console.log('Citas recibidas del backend:', data);

        if (data.length === 0) {
          Swal.fire('Sin resultados', 'No hay pacientes agendados para esta fecha.', 'info');
        }
      },
      error => {
        Swal.close();
        Swal.fire('Error', 'No se pudo obtener la lista de pacientes.', 'error');
        console.error('Error al obtener pacientes:', error);
      }
    );
  }

  redireccion_historia(cita: Cita): void {

    this.citaselect = cita;

    console.log(this.citaselect)

    this.router.navigate(['/historia-clinica'], {
      state: { cita: this.citaselect }
    });
  }

  lista_dia(){

    this.servicioCitas.citas_del_Dia2().subscribe(dato =>{
      this.lista_citas= dato
    })
  }

  SesionComomedico() {
    this.logueoService.setTipoUsuario('medico');
  }

}
