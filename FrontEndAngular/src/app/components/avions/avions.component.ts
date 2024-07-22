import { Component } from '@angular/core';
import { GrapheComponent } from "../child-components/graphe/graphe.component";

@Component({
  selector: 'app-avions',
  standalone: true,
  imports: [GrapheComponent],
  templateUrl: './avions.component.html',
  styleUrl: './avions.component.css'
})
export class AvionsComponent {

}
