import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AeroportComponent } from './components/aeroport/aeroport.component';
import { AvionsComponent } from './components/avions/avions.component';
import { FaqComponent } from './components/faq/faq.component';
import { ParametresComponent } from './components/parametres/parametres.component';
import { PassagersComponent } from './components/passagers/passagers.component';
import { PersonnelComponent } from './components/personnel/personnel.component';
import { VolsComponent } from './components/vols/vols.component';
import { AjouterPassagerComponent } from './components/passagers/ajouter-passager/ajouter-passager.component';
import { ModifierPassagerComponent } from './components/passagers/modifier-passager/modifier-passager.component';

export const routes: Routes = [
    {path: "aeroport",title: "aeroport", component: AeroportComponent},
    {path: "avions",title: "avions", component: AvionsComponent},
    {path: "faq",title: "faq", component: FaqComponent},
    {path: "parametres", title: "parametres", component: ParametresComponent},
    {path: "passagers",title: "passagers", component: PassagersComponent},
    {path: "personnel",title: "personnel", component: PersonnelComponent},
    {path: "vols",title: "vols", component: VolsComponent},
    {path:"ajouterPassager",component:AjouterPassagerComponent},
    { path:"modifier-passager/:id", component: ModifierPassagerComponent }

];
