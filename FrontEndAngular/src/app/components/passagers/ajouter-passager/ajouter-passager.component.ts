import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PassagerService } from '../passager.service';

@Component({
  selector: 'app-ajouter-passager',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './ajouter-passager.component.html',
  styleUrl: './ajouter-passager.component.css'
})
export class AjouterPassagerComponent {
  ajouterLogo:string="assets/images/Ajouter.png"
  applyForm =new FormGroup({
    nom:new FormControl(''),
    prenom:new FormControl(''),
    email:new FormControl(''),
    tel:new FormControl(''),
    password  :new FormControl('')
  });
  constructor(private passagerService:PassagerService){

  }
  
  async submitApp() {
    const { nom, prenom, email, tel, password } = this.applyForm.value;
    try {
      // Utilisation de ?? pour fournir une chaîne vide par défaut si la valeur est null ou undefined
      await this.passagerService.addPassager({
        nom: nom ?? '',
        prenom: prenom ?? '',
        email: email ?? '',
        tel: tel ?? '',
        password: password ?? ''
      });
      this.applyForm.reset(); // Réinitialiser le formulaire après succès
      alert('Passager ajouté avec succès !'); // Optionnel : Message de succès
    } catch (error) {
      console.error('Erreur lors de l\'ajout du passager :', error);
    }
  }
}
