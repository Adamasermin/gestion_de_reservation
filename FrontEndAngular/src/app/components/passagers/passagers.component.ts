import { CommonModule } from '@angular/common';
import { identifierName } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Passager } from './passager';
import { PassagerService } from './passager.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-passagers',
  standalone: true,
  imports: [CommonModule,RouterLink],
  templateUrl: './passagers.component.html',
  styleUrl: './passagers.component.css'
})
export class PassagersComponent implements OnInit {
  passagerLogo:string="assets/images/passagers.png"
  statistiqueImage:string="assets/images/stats.png"
  ajouterLogo:string="assets/images/Ajouter.png"
  ngOnInit(): void {
      
  }
  passagerList:Passager[]=[];
  constructor(private passagerService:PassagerService){
    this.passagerService.getAllpassager().then((passagerList:Passager[])=>{
      this.passagerList =passagerList;
    })
  }
 async deletePassager(id:number):Promise<void>{
  if(confirm("vous etes sur de supprimer definitivemen?"))
  try {
    
    await this.passagerService.deletePassager(id);
    this.passagerList =this.passagerList.filter(p=>p.id !==id);
    
  } catch (error) {
    console.error("erreur lors de la suppression du passager");
    
  }
 }
}

