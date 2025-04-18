import { CitaService } from './../../servicios/cita.service';
import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Medico } from '../../entidades/medico';
import {Cita} from '../../entidades/cita';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-solicitar-cita',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './solicitar-cita.component.html',
  styleUrl: './solicitar-cita.component.css'
})
export class SolicitarCitaComponent implements OnInit{

ngOnInit(): void{

}

constructor(private CitasServicios:CitaService){}

fecha!: Date;
hora!: string;
motivo!: string;
med!: Medico;

cita: Cita= new Cita;

citas!: Cita[];

agendarCita() {
  this.CitasServicios.agendar_cita(this.fecha, this.hora, this.motivo, this.med).subscribe(dato=>{

      if(dato){
        alert("Cita Agendada")

        this.cita=dato;
        window.location.reload()
      }else{
        alert("La solicitud a fallado")
      }

    }
     
    );
}

}

