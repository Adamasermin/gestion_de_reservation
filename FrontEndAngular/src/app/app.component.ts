import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BarNavigationComponent } from "./components/child-components/bar-navigation/bar-navigation.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, BarNavigationComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
}
