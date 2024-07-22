import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BarNavigationComponent } from "./components/child-components/bar-navigation/bar-navigation.component";
import { BarRechercheComponent } from "./components/child-components/bar-recherche/bar-recherche.component";
import { GrapheComponent } from "./components/child-components/graphe/graphe.component";
import { HomeComponent } from "./components/home/home.component";
import {InscriptionComponent} from "./components/page_inscription_connexion/inscription/inscription.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    BarNavigationComponent,
    BarRechercheComponent,
    GrapheComponent,
    HomeComponent,
    InscriptionComponent
],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

}
