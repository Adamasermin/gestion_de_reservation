import { Component } from '@angular/core';
import { NgOptimizedImage } from '@angular/common';
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-bar-recherche',
  standalone: true,
  imports: [NgOptimizedImage],
  templateUrl: './bar-recherche.component.html',
  styleUrl: './bar-recherche.component.css'
})
export class BarRechercheComponent {

  constructor(private userService: UserService, private router: Router) {}

  getUsername(): string | null {
    return localStorage.getItem('username');
  }

  logout() {
    this.userService.logout().subscribe(response => {
      localStorage.removeItem('username');
      this.router.navigate(['/login']);
    }, error => {
      console.error('Logout error: ', error);
    });
  }


  profil: string = "assets/images/Profil.png"
}
