import { Component, OnInit } from '@angular/core';
import { Cita } from '../../entidades/cita';
import { PacienteService } from '../../servicios/paciente.service';
import { CitaService } from '../../servicios/cita.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ver-citas',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './ver-citas.component.html',
  styleUrl: './ver-citas.component.css'
})
export class VerCitasComponent implements OnInit {

  citas!:Cita[]
  citasAnteriores: Cita[] = [];
  mostrarProximas: boolean = true;

  constructor(private ServicePaciente:PacienteService,
    private Servicecita:CitaService
  ){}

  ngOnInit(): void {
    this.citas_proximas();
  }

  citas_proximas(): void {
    this.Servicecita.ver_Proximas_Citas().subscribe(data => {
      this.citas = data;
    });
  }

  citas_anteriores(): void {
    this.Servicecita.ver_historial_citas().subscribe(data => {
      this.citasAnteriores = data;
    });
  }

  cancelar_cita(idcita: number): void {
    this.Servicecita.cancelar_Cita(idcita).subscribe(() => {
      this.citas_proximas(); // refrescar citas
    });
  }

  ocultar_tabla_citas_proximas(): void {
    this.mostrarProximas = false;
    this.citas_anteriores();
  }
}


