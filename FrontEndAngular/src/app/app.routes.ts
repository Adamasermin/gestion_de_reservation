import { Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { AeroportComponent } from './components/aeroport/aeroport.component';
import { AvionsComponent } from './components/avions/avions.component';
import { FaqComponent } from './components/faq/faq.component';
import { ParametresComponent } from './components/parametres/parametres.component';
import { PassagersComponent } from './components/passagers/passagers.component';
import { PersonnelComponent } from './components/personnel/personnel.component';
import { VolsComponent } from './components/vols/vols.component';
import { ConnexionComponent } from './components/page_inscription_connexion/connexion/connexion.component';

export const routes: Routes = [
    {path: "home", title: "home", component: HomeComponent},
    {path: "aeroport",title: "aeroport", component: AeroportComponent},
    {path: "avions",title: "avions", component: AvionsComponent},
    {path: "faq",title: "faq", component: FaqComponent},
    {path: "parametres", title: "parametres", component: ParametresComponent},
    {path: "passagers",title: "passagers", component: PassagersComponent},
    {path: "personnel",title: "personnel", component: PersonnelComponent},
    {path: "vols",title: "vols", component: VolsComponent},
    {path: "login", title: "login", component: ConnexionComponent},
    {path: '', redirectTo: "/login", pathMatch: "full"}
];
