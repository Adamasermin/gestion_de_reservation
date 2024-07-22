import { NgOptimizedImage } from '@angular/common';
import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-connexion',
  standalone: true,
  imports: [NgOptimizedImage, FormsModule, HttpClientModule],
  templateUrl: './connexion.component.html',
  styleUrl: './connexion.component.css'
})
export class ConnexionComponent {

  credentials =
    {
      username: '',
      password: ''
    };
  message = '';

  constructor(
    private userService: UserService,
    private router: Router
  ){}

  login() {
    this.userService.login(this.credentials).subscribe(response => {
      console.log(response);
      localStorage.setItem('username', response);

      this.router.navigate(['/home']);
      this.credentials = { username: '', password: '' };
    }, error => {
      
      this.message = 'Invalid username or password';
      this.credentials = { username: '', password: '' };
    });
  }

  logo1: string = "assets/images/logoToolbar.png";
  person: string ="assets/images/person.png";
  eyes: string ="assets/images/eye.png";
}
