import { AfterViewInit, Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-barra-navegacion-footer',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './barra-navegacion-footer.component.html',
  styleUrl: './barra-navegacion-footer.component.css'
})
export class BarraNavegacionFooterComponent implements AfterViewInit {


  ngAfterViewInit(): void {

    this.interaccion_navegacion(2);
  }


  // Declaracion de variables

  @ViewChild('paciente') paciente!: ElementRef;
  @ViewChild('medico') medico!: ElementRef;
  @ViewChild('Recep') Recep!: ElementRef;
  @ViewChild('Loguin') log!: ElementRef;

  // constructor 

  constructor(private renderer: Renderer2) {}
  
  
  
  // Funciones
  interaccion_navegacion(num:number){

    switch(num){
      case 1:
        this.ver_Loguins()
        break
      
      case 2:
        this.barra_paciente()
        break

      case 3:
        this.barra_medico()
        break

      case 4:
        this.barra_Recep()
        break
    }
  }


  ver_Loguins(){

    this.renderer.setStyle(this.paciente.nativeElement,'display','none');
    this.renderer.setStyle(this.medico.nativeElement,'display','none');
    this.renderer.setStyle(this.Recep.nativeElement,'display','none');
    this.renderer.setStyle(this.log.nativeElement,'display','block');

  }

  

  barra_paciente(){

    this.renderer.setStyle(this.paciente.nativeElement,'display','block');
    this.renderer.setStyle(this.medico.nativeElement,'display','none');
    this.renderer.setStyle(this.Recep.nativeElement,'display','none');
    this.renderer.setStyle(this.log.nativeElement,'display','none');

  }

  barra_medico(){

    this.renderer.setStyle(this.paciente.nativeElement,'display','none');
    this.renderer.setStyle(this.medico.nativeElement,'display','block');
    this.renderer.setStyle(this.Recep.nativeElement,'display','none');
    this.renderer.setStyle(this.log.nativeElement,'display','none');



  }

  barra_Recep(){

    this.renderer.setStyle(this.paciente.nativeElement,'display','none');
    this.renderer.setStyle(this.medico.nativeElement,'display','block');
    this.renderer.setStyle(this.Recep.nativeElement,'display','none');
    this.renderer.setStyle(this.log.nativeElement,'display','none');



  }

}
