import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule ,FormGroup,FormControl, NgModel} from '@angular/forms';
import { PassagerService } from '../passager.service';
import { ActivatedRoute } from '@angular/router';
import { Passager } from '../passager';

@Component({
  selector: 'app-modifier-passager',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './modifier-passager.component.html',
  styleUrl: './modifier-passager.component.css'
})
export class ModifierPassagerComponent implements OnInit {
  id:any;
  list: any;
  passager: Passager | null = null;
  passagerList:Passager[]=[];
  constructor(private passagerService:PassagerService,private route:ActivatedRoute){
    
  }
  ajouterLogo:string="assets/images/Ajouter.png"
  applyForm = new FormGroup({
    nom:new FormControl(''),
    prenom:new FormControl(''),
    email:new FormControl(''),
    tel:new FormControl(''),
    password  :new FormControl('')
  });
  

  ngOnInit(): void {
   this.id= this.route.snapshot.params["id"]
    
    this.fetchPassager(this.id);
    
  }
  async fetchPassager(id: number): Promise<void> {
    this.passager = await this.passagerService.getPassagerById(id);
    console.log(this.passager)
    this.applyForm.patchValue({
      nom: this.passager.nom,
      prenom: this.passager.prenom,
      email: this.passager.email,
      tel: this.passager.tel,
      password: this.passager.password
    });
  }
  async submitApp(): Promise<void> {
    const updatedPassager: Passager = {
      id: this.id,
      ...this.applyForm.value
    } as Passager;

    try {
      await this.passagerService.updtatePassager(updatedPassager);
      this.applyForm.reset();
      alert("Passager modifié avec succès");
    } catch (error) {
      console.log("Erreur lors de la modification", error);
    }
  }
}

