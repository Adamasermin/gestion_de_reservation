import { Component } from '@angular/core';
import { FormBuilder, FormGroup,ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule

 } from '@angular/common';
@Component({
  selector: 'app-ajouter-compagnie',
  standalone: true,
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './ajouter-compagnie.component.html',
  styleUrl: './ajouter-compagnie.component.css'
})
export class AjouterCompagnieComponent {
  formulaireCompagnie : FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.formulaireCompagnie = this.formBuilder.group({
      nomCompagnie: ['', Validators.required],
      description: ['', Validators.required],
      adresse: ['', Validators.required],
      motDePasse: ['', Validators.required],
      logo: null
    });
  }

  onFileChange(event: any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.formulaireCompagnie.patchValue({
        logo: file
      });
    }
  }

  onSubmit() {
      const formData = new FormData();
      formData.append('nomCompagnie', this.formulaireCompagnie.get('nomCompagnie')?.value);
      formData.append('description', this.formulaireCompagnie.get('description')?.value);
      formData.append('adresse', this.formulaireCompagnie.get('adresse')?.value);
      formData.append('motDePasse', this.formulaireCompagnie.get('motDePasse')?.value);
      formData.append('logo', this.formulaireCompagnie.get('logo')?.value);

      console.log('Formulaire soumis:', formData);
  }
}

