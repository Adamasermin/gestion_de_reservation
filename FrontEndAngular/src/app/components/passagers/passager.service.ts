import { Injectable } from '@angular/core';
import { Passager } from './passager';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PassagerService {
  url="http://localhost:8080/passager";

  constructor( ) { }
  //recuperation des passager 
  async getAllpassager():Promise<Passager[]>{
    const data =await fetch(this.url);
    return await data.json() ?? [];
  }
  //ajout d'un passager
  async addPassager(passager:Passager): Promise<Passager>{
    const data = await fetch(this.url,{
      method:'POST',
      headers:{
        'Content-Type': 'application/json'
      },
      body:JSON.stringify(passager)
    });
    return await data.json();
  }
  //modification d'un passager
  async updtatePassager(passager:Passager):Promise<Passager>{
    const data = await fetch(`${this.url}${passager.id}`,{
      method:'PUT',
      headers:{
        'Content-Type': 'application/json'
      },
      body:JSON.stringify(passager)
    });
    return await data.json();
  }
  //supprimer un passager
  async deletePassager(id:number):Promise<void>{
    const data = await fetch(`${this.url}/${id}`,{
      method:'DELETE',
  });
  }
   async submitApp(nom:string,prenom:string,email:string,tel:string,password:string){
    console.log(nom,prenom,email,tel,password,);
    const passager:Passager ={nom,prenom,email,tel,password}
    return await this.addPassager(passager)

  }
}


