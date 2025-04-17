import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BarraNavegacionFooterComponent } from './barra-navegacion-footer/barra-navegacion-footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, BarraNavegacionFooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend_historias_clinicas';
}
