import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Paciente } from '../../entidades/paciente';
import { ActivatedRoute, Router } from '@angular/router';
import { PacienteService } from '../../servicios/paciente.service';
import Swal from 'sweetalert2';
import { LogueosService } from '../../servicios/logueos.service';
import { LoginsService } from '../../servicios/logins.service';
import { CommonModule } from '@angular/common';
import { LoguinPaciente } from '../../entidades/loguin-paciente';

@Component({
  selector: 'app-actualizar-paciente',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './actualizar-paciente.component.html',
  styleUrl: './actualizar-paciente.component.css'
})
export class ActualizarPacienteComponent implements OnInit {

  paciente: LoguinPaciente = new LoguinPaciente();
  id: number = 0;
  nuevaPassword: string = ''; 
  
  constructor(
    private serpa: PacienteService,
    private route: ActivatedRoute,
    private serLoguin : LoginsService,
    private router: Router,
     private logueoService: LogueosService
  ) {}

  ngOnInit(): void {
    
    this.serLoguin.obtenerPaciente().subscribe(dtao=>{
    this.paciente = dtao
    console.log("paciente", this.paciente)
    })

    this.SesionComoPaciente()
  }

  // funcion que muestra la barra de navegacion como paciente
  SesionComoPaciente() {
    this.logueoService.setTipoUsuario('paciente');
  }

  validar_loguin(formulrio: NgForm){

    if(formulrio.invalid){
      Swal.fire('Atención', 'debe de llenar todos los campos para actualizar los datos', 'warning');

    }else{
      this.actualizarPaciente()
    }




  }

  actualizarPaciente(): void {
    this.serpa.actualizar_Paciente(this.paciente).subscribe(res => {
      if (res === true) {
        Swal.fire('Éxito', 'Paciente actualizado con éxito', 'success');
        this.router.navigate(['/ver-citas']);
      } else {
        Swal.fire('Error', 'No se pudo actualizar el paciente. El correo puede estar en uso.', 'error');
      }
    }, error => {
      Swal.fire('Error', 'Hubo un error al actualizar el paciente.', 'error');
    });
  }

}
