import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Avion } from './avion';

@Component({
  selector: 'app-avions',
  standalone: true,
  imports: [CommonModule,RouterLink],
  templateUrl: './avions.component.html',
  styleUrl: './avions.component.css'
})
export class AvionsComponent {
  avionLogo:string="assets/images/Avions.png"
  statsLogo:string="assets/images/stats.png"
  ajouterLogo:string="assets/images/Ajouter.png"
  avionList:Avion[]=[
    {
      id:1,
      immatriculation:"24FRTC",
      capacite:"200 passager",
      modele:"Boieng"
    }
  ];



}
