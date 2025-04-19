import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HistoriaClinicaService } from '../../servicios/historia-clinica.service';
import { Router } from '@angular/router';
import { HistorialClinico } from '../../entidades/historial-clinico';


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
    const historiaCompleta = {
      ...this.nueva_historia,
      paciente: this.paciente
    };

    this.ServiceHistorial.registrarHistorial(historiaCompleta).subscribe(
      (respuesta) => {
        alert('Historial registrado exitosamente');
        this.redireccion_lista_pacientes();
      },
      (error) => {
        alert('Error al registrar el historial');
      }
    );
  }

  redireccion_lista_pacientes(): void {
    this.router.navigate(['/lista-pacientes']);
  }

}
