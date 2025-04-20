import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HistoriaClinicaService } from '../../servicios/historia-clinica.service';
import { Router } from '@angular/router';
import { HistorialClinico } from '../../entidades/historial-clinico';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-historia-clinica',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './historia-clinica.component.html',
  styleUrl: './historia-clinica.component.css'
})
export class HistoriaClinicaComponent implements OnInit {

  

  paciente: any = {}; 
  nueva_historia: HistorialClinico = new HistorialClinico();

  constructor(
    private ServiceHistorial: HistoriaClinicaService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const navigation = this.router.getCurrentNavigation();
    const datosPaciente = navigation?.extras?.state?.['paciente'];
    if (datosPaciente) {
      this.paciente = datosPaciente;
    }
  }
  
  Guardar_historial(): void {
    if (!this.nueva_historia.motivo || !this.nueva_historia.diagnostico) {
      Swal.fire('Campos incompletos', 'Por favor llena los campos requeridos.', 'warning');
      return;
    }

   

    const historiaCompleta = {
      ...this.nueva_historia,
      paciente: this.paciente
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
