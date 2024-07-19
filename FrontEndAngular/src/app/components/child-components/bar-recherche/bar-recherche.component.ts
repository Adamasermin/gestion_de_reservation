import { Component } from '@angular/core';
import { NgOptimizedImage } from '@angular/common';

@Component({
  selector: 'app-bar-recherche',
  standalone: true,
  imports: [NgOptimizedImage],
  templateUrl: './bar-recherche.component.html',
  styleUrl: './bar-recherche.component.css'
})
export class BarRechercheComponent {
  profil: string = "assets/images/Profil.png"
}
