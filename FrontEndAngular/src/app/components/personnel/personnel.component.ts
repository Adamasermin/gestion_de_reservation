import { Component } from '@angular/core';
import { GrapheComponent } from "../child-components/graphe/graphe.component";

@Component({
  selector: 'app-personnel',
  standalone: true,
  imports: [GrapheComponent],
  templateUrl: './personnel.component.html',
  styleUrl: './personnel.component.css'
})
export class PersonnelComponent {

}
