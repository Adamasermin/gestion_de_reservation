import { Component } from '@angular/core';
import { NgOptimizedImage } from '@angular/common';
import {RouterOutlet, RouterLink} from '@angular/router';

@Component({
  selector: 'app-bar-navigation',
  standalone: true,
  imports: [NgOptimizedImage, RouterOutlet, RouterLink],
  templateUrl: './bar-navigation.component.html',
  styleUrl: './bar-navigation.component.css'
})
export class BarNavigationComponent {
  logo1: string = "assets/images/logoToolbar.png";
  logo: string = "assets/images/logo2.png";
  home: string = "assets/images/Home.png";
  vols: string = "assets/images/vol-direct 1.png";
  personnels: string = "assets/images/Personnel.png";
  aeroport: string = "assets/images/aeroport 1.png";
  passagers: string = "assets/images/passagers 1.png";
  avions: string = "assets/images/Avions.png";
  parametres: string = "assets/images/Settings.png";
  faq: string = "assets/images/faq1.png";

}
