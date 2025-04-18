
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BarraNavegacionFooterComponent } from './barra-navegacion-footer/barra-navegacion-footer.component';
import { InicioSecionComponent } from './inicio-secion/inicio-secion.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,InicioSecionComponent, BarraNavegacionFooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend_historias_clinicas';
}
