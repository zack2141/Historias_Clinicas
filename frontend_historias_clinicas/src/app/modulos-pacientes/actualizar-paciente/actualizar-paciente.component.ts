import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Paciente } from '../../entidades/paciente';
import { ActivatedRoute, Router } from '@angular/router';
import { PacienteService } from '../../servicios/paciente.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-actualizar-paciente',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './actualizar-paciente.component.html',
  styleUrl: './actualizar-paciente.component.css'
})
export class ActualizarPacienteComponent implements OnInit {

  paciente: Paciente = new Paciente();
  id: number = 0;
  nuevaPassword: string = ''; 
  
  constructor(
    private serpa: PacienteService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.serpa.ver_Paciente(this.id).subscribe(data => {
      if (data) {
        this.paciente = data;
      } else {
        Swal.fire('Paciente no encontrado', '', 'error');
      }
    });
  }

  actualizarPaciente(): void {
    this.serpa.actualizar_Paciente(this.paciente).subscribe(res => {
      if (res === true) {
        Swal.fire('Éxito', 'Paciente actualizado con éxito', 'success');
        this.router.navigate(['/lista-pacientes']);
      } else {
        Swal.fire('Error', 'No se pudo actualizar el paciente. El correo puede estar en uso.', 'error');
      }
    }, error => {
      Swal.fire('Error', 'Hubo un error al actualizar el paciente.', 'error');
    });
  }

}
