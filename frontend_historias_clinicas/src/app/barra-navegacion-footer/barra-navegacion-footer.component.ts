import { AfterViewInit, ChangeDetectorRef, Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { InicioSecionComponent } from '../inicio-secion/inicio-secion.component';
import { LogueosService } from '../servicios/logueos.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-barra-navegacion-footer',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './barra-navegacion-footer.component.html',
  styleUrl: './barra-navegacion-footer.component.css'
})
export class BarraNavegacionFooterComponent implements OnInit{

  constructor(private renderer: Renderer2, private logueoService: LogueosService,private cdRef: ChangeDetectorRef) {}

  ngOnInit(): void {
     this.logueos()
    
  }

  tipoUsuario: string = '';

  logueos(){

    this.logueoService.tipoUsuario$.subscribe(tipo => {
      this.tipoUsuario = tipo;
      this.cdRef.detectChanges(); // Esto le dice a Angular que vuelva a verificar el cambio de los valores de las barras de navegacion
    });

  }


  // Declaracion de variables
  /*
  @ViewChild('paciente') paciente!: ElementRef; // para elementos propios del html
  @ViewChild('medico') medico!: ElementRef; // para elementos propios del html
  @ViewChild('Recep') Recep!: ElementRef; // para elementos propios del html
  @ViewChild('Loguin', { read: ElementRef }) log!: ElementRef; //para leer modulos externos

  
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
      
      case 5:
        this.ver_registro_paciente()
        break
    }
  }

  ver_registro_paciente(){

    this.renderer.setStyle(this.log.nativeElement,'display','none');

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
 */

}
