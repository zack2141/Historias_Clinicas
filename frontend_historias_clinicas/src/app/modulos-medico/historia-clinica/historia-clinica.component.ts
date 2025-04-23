import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { HistoriaClinicaService } from '../../servicios/historia-clinica.service';
import { Router } from '@angular/router';
import { HistorialClinico } from '../../entidades/historial-clinico';
import Swal from 'sweetalert2';
import { Cita } from '../../entidades/cita';
import { CommonModule } from '@angular/common';
import { Location } from '@angular/common'
import { Paciente } from '../../entidades/paciente';
import { LogueosService } from '../../servicios/logueos.service';


@Component({
  selector: 'app-historia-clinica',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './historia-clinica.component.html',
  styleUrl: './historia-clinica.component.css'
})
export class HistoriaClinicaComponent implements OnInit {

  

  cita: Cita = {
    idcita: 0,
    hora: '',
    fecha: new Date(),
    idrecepcionista:null,
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

  nueva_historia: HistorialClinico ={
    recetaMedicamentos: '',
    motivoCita: '',
    enfermedadPaciente: '',
    observaciones: '',
    examenesComplementario: '',
    diagnosticos: '',
    idmedico: null,
    idpaciente : null,
    idHistorial: 0,
    tratamientos: ""
  }

  constructor(
    private ServiceHistorial: HistoriaClinicaService,
    private router: Router,
    private location: Location,
    private logueoService: LogueosService
  ) {}

  ngOnInit(): void {
    const state = this.location.getState() as { cita?: Cita }; // para obtener la cita desde el anterior modulo cuando se utiliza router navigation

    if (state && state.cita) {
      this.cita = state.cita;

      this.nueva_historia.idpaciente = this.cita.idpaciente
      console.log("✅ Cita recibida:", this.cita);
    } else {
      console.warn("⚠️ No se recibió la cita.");
    }

    this.SesionComomedico()
  }

  validacion_formulario(formulario:NgForm){
    if(formulario.invalid){
      Swal.fire('Campos incompletos', 'Por favor llena los campos requeridos.', 'warning');

    }
    else{
      this.Guardar_historial()
    }
  }
  
  Guardar_historial(): void {

  

    Swal.fire({
      title: 'Guardando historial...',
      didOpen: () => {
        Swal.showLoading();
      },
      allowOutsideClick: false
    });

    this.ServiceHistorial.registrarHistorial(this.nueva_historia, this.cita.idcita).subscribe(
      (respuesta) => {
        Swal.close();
        Swal.fire('Éxito', 'Historial registrado exitosamente.', 'success').then(() => {
          this.redireccion_lista_pacientes();
        });
      },
      (error) => {
        Swal.close();
        Swal.fire('Error', 'Hubo un problema al registrar el historial.', 'error');
        console.error(error);
      }
    );
  }

  redireccion_lista_pacientes(): void {
    this.router.navigate(['/lista-pacientes']);
  }

  SesionComomedico() {
    this.logueoService.setTipoUsuario('medico');
  }
}
