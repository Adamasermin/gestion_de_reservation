import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AjouterCompagnieComponent } from './components/ajouter-compagnie/ajouter-compagnie.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AjouterCompagnieComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'FrontEndAngular';
}
