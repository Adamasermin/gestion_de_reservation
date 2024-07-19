import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BarNavigationComponent } from "./components/child-components/bar-navigation/bar-navigation.component";
import { BarRechercheComponent } from "./components/child-components/bar-recherche/bar-recherche.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, BarNavigationComponent, BarRechercheComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
}
