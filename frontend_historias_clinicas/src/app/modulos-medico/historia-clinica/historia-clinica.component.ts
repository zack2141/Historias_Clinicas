import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HistoriaClinicaService } from '../../servicios/historia-clinica.service';
import { Router } from '@angular/router';
import { HistorialClinico } from '../../entidades/historial-clinico';
import Swal from 'sweetalert2';
import { Cita } from '../../entidades/cita';
import { CommonModule } from '@angular/common';
import { Location } from '@angular/common'


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
  nueva_historia: HistorialClinico = new HistorialClinico();

  constructor(
    private ServiceHistorial: HistoriaClinicaService,
    private router: Router,
    private location: Location
  ) {}

  ngOnInit(): void {
    const state = this.location.getState() as { cita?: Cita }; // para obtener la cita desde el anterior modulo cuando se utiliza router navigation

    if (state && state.cita) {
      this.cita = state.cita;
      console.log("✅ Cita recibida:", this.cita);
    } else {
      console.warn("⚠️ No se recibió la cita.");
    }
  }
  
  Guardar_historial(): void {
    if (!this.nueva_historia.motivo || !this.nueva_historia.diagnostico) {
      Swal.fire('Campos incompletos', 'Por favor llena los campos requeridos.', 'warning');
      return;
    }

   

    const historiaCompleta = {
      ...this.nueva_historia,
      paciente: this.cita
    };

    Swal.fire({
      title: 'Guardando historial...',
      didOpen: () => {
        Swal.showLoading();
      },
      allowOutsideClick: false
    });

    this.ServiceHistorial.registrarHistorial(historiaCompleta).subscribe(
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
}
