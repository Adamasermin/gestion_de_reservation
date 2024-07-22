import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../../services/user.service";
import {BarNavigationComponent} from "../../child-components/bar-navigation/bar-navigation.component";
import {BarRechercheComponent} from "../../child-components/bar-recherche/bar-recherche.component";
@Component({
  selector: 'app-inscription',
  standalone: true,
  imports: [
    BarNavigationComponent,
    BarRechercheComponent
  ],
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.css'
})
export class InscriptionComponent {

  registerForm!: FormGroup;

  constructor(
    private userService: UserService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      nom: ['', [Validators.required]],
      prenom: ['', [Validators.required]],
      email: ['', [Validators.required]],
      tel: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.email]],
      confirmPassword: ['', [Validators.required]],
    }, {validator: this.passwordMatchValidator });
  }
  passwordMatchValidator(formGroup: FormGroup){
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;

    if(password != confirmPassword){
      formGroup.get('confirmPassword')?.setErrors({ passwordMismatch: true });
    }else{
      formGroup.get('confirmPassword')?.setErrors(null);
    }
  }
}
