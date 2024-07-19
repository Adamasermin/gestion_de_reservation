import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { VolsComponent } from "./components/vols/vols.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, VolsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'FrontEndAngular';
}
