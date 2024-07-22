import { Component } from '@angular/core';
import { GrapheComponent } from "../child-components/graphe/graphe.component";
import { BarNavigationComponent } from "../child-components/bar-navigation/bar-navigation.component";
import { BarRechercheComponent } from "../child-components/bar-recherche/bar-recherche.component";


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [GrapheComponent, BarNavigationComponent, BarRechercheComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
