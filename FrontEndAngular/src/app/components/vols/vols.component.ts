import { VolService } from './../../Services/vol.service';
import { Component, OnInit } from '@angular/core';
import { StatReserComponent } from "./stat-reser/stat-reser.component";
import { ChartComponent } from './chart/chart.component';

@Component({
  selector: 'app-vols',
  standalone: true,
  imports: [StatReserComponent,ChartComponent],
  templateUrl: './vols.component.html',
  styleUrl: './vols.component.css'
})
export class VolsComponent implements OnInit{
  vols: any[] = [];

  constructor(private volService: VolService){}

  ngOnInit(): void {
      this.volService.getVol().subscribe((data) => {

        this.vols = data;
        console.log(this.vols);
      });
  }

  volls: any[] = [
    { id: 1, date_depart: '2024-07-01', date_retour: '2024-07-10', nbre_de_place_dispo: 150, tarif: 300, ville_arrive: 'Paris', ville_depart: 'New York', aeroport_id: 1 },
    { id: 2, date_depart: '2024-07-02', date_retour: '2024-07-12', nbre_de_place_dispo: 120, tarif: 250, ville_arrive: 'London', ville_depart: 'Los Angeles', aeroport_id: 2 },
    { id: 3, date_depart: '2024-07-03', date_retour: '2024-07-13', nbre_de_place_dispo: 100, tarif: 400, ville_arrive: 'Berlin', ville_depart: 'Chicago', aeroport_id: 3 },
    { id: 4, date_depart: '2024-07-04', date_retour: '2024-07-14', nbre_de_place_dispo: 130, tarif: 350, ville_arrive: 'Tokyo', ville_depart: 'San Francisco', aeroport_id: 4 },
    { id: 5, date_depart: '2024-07-05', date_retour: '2024-07-15', nbre_de_place_dispo: 160, tarif: 280, ville_arrive: 'Rome', ville_depart: 'Miami', aeroport_id: 5 },
    { id: 6, date_depart: '2024-07-06', date_retour: '2024-07-16', nbre_de_place_dispo: 140, tarif: 320, ville_arrive: 'Amsterdam', ville_depart: 'Houston', aeroport_id: 6 },
    { id: 7, date_depart: '2024-07-07', date_retour: '2024-07-17', nbre_de_place_dispo: 110, tarif: 270, ville_arrive: 'Barcelona', ville_depart: 'Dallas', aeroport_id: 7 },
    { id: 8, date_depart: '2024-07-08', date_retour: '2024-07-18', nbre_de_place_dispo: 90, tarif: 450, ville_arrive: 'Dubai', ville_depart: 'Seattle', aeroport_id: 8 },
    { id: 9, date_depart: '2024-07-09', date_retour: '2024-07-19', nbre_de_place_dispo: 180, tarif: 220, ville_arrive: 'Sydney', ville_depart: 'Boston', aeroport_id: 9 },
    { id: 10, date_depart: '2024-07-10', date_retour: '2024-07-20', nbre_de_place_dispo: 200, tarif: 500, ville_arrive: 'Melbourne', ville_depart: 'Philadelphia', aeroport_id: 10 },
    { id: 11, date_depart: '2024-07-11', date_retour: '2024-07-21', nbre_de_place_dispo: 150, tarif: 280, ville_arrive: 'Munich', ville_depart: 'Phoenix', aeroport_id: 11 },
    { id: 12, date_depart: '2024-07-12', date_retour: '2024-07-22', nbre_de_place_dispo: 130, tarif: 310, ville_arrive: 'Vienna', ville_depart: 'San Antonio', aeroport_id: 12 },
    { id: 13, date_depart: '2024-07-13', date_retour: '2024-07-23', nbre_de_place_dispo: 170, tarif: 330, ville_arrive: 'Milan', ville_depart: 'San Diego', aeroport_id: 13 },
    { id: 14, date_depart: '2024-07-14', date_retour: '2024-07-24', nbre_de_place_dispo: 140, tarif: 360, ville_arrive: 'Zurich', ville_depart: 'Dallas', aeroport_id: 14 },
    { id: 15, date_depart: '2024-07-15', date_retour: '2024-07-25', nbre_de_place_dispo: 180, tarif: 290, ville_arrive: 'Istanbul', ville_depart: 'Denver', aeroport_id: 15 },
    { id: 16, date_depart: '2024-07-16', date_retour: '2024-07-26', nbre_de_place_dispo: 160, tarif: 310, ville_arrive: 'Athens', ville_depart: 'Atlanta', aeroport_id: 16 },
    { id: 17, date_depart: '2024-07-17', date_retour: '2024-07-27', nbre_de_place_dispo: 200, tarif: 250, ville_arrive: 'Lisbon', ville_depart: 'Detroit', aeroport_id: 17 },
    { id: 18, date_depart: '2024-07-18', date_retour: '2024-07-28', nbre_de_place_dispo: 150, tarif: 400, ville_arrive: 'Madrid', ville_depart: 'Las Vegas', aeroport_id: 18 },
    { id: 19, date_depart: '2024-07-19', date_retour: '2024-07-29', nbre_de_place_dispo: 130, tarif: 450, ville_arrive: 'Moscow', ville_depart: 'Baltimore', aeroport_id: 19 },
    { id: 20, date_depart: '2024-07-20', date_retour: '2024-07-30', nbre_de_place_dispo: 170, tarif: 280, ville_arrive: 'Helsinki', ville_depart: 'Newark', aeroport_id: 20 },
    { id: 21, date_depart: '2024-07-21', date_retour: '2024-07-31', nbre_de_place_dispo: 120, tarif: 320, ville_arrive: 'Stockholm', ville_depart: 'Orlando', aeroport_id: 21 },
    { id: 22, date_depart: '2024-07-22', date_retour: '2024-08-01', nbre_de_place_dispo: 90, tarif: 360, ville_arrive: 'Copenhagen', ville_depart: 'San Francisco', aeroport_id: 22 },
    { id: 23, date_depart: '2024-07-23', date_retour: '2024-08-02', nbre_de_place_dispo: 160, tarif: 410, ville_arrive: 'Oslo', ville_depart: 'Washington', aeroport_id: 23 },
    { id: 24, date_depart: '2024-07-24', date_retour: '2024-08-03', nbre_de_place_dispo: 180, tarif: 340, ville_arrive: 'Brussels', ville_depart: 'Boston', aeroport_id: 24 },
    { id: 25, date_depart: '2024-07-25', date_retour: '2024-08-04', nbre_de_place_dispo: 140, tarif: 370, ville_arrive: 'Warsaw', ville_depart: 'Miami', aeroport_id: 25 },
    { id: 26, date_depart: '2024-07-26', date_retour: '2024-08-05', nbre_de_place_dispo: 150, tarif: 300, ville_arrive: 'Prague', ville_depart: 'New York', aeroport_id: 26 },
    { id: 27, date_depart: '2024-07-27', date_retour: '2024-08-06', nbre_de_place_dispo: 120, tarif: 260, ville_arrive: 'Vienna', ville_depart: 'Los Angeles', aeroport_id: 27 },
    { id: 28, date_depart: '2024-07-28', date_retour: '2024-08-07', nbre_de_place_dispo: 130, tarif: 420, ville_arrive: 'Budapest', ville_depart: 'Chicago', aeroport_id: 28 },
    { id: 29, date_depart: '2024-07-29', date_retour: '2024-08-08', nbre_de_place_dispo: 140, tarif: 280, ville_arrive: 'Athens', ville_depart: 'Houston', aeroport_id: 29 },
    { id: 30, date_depart: '2024-07-30', date_retour: '2024-08-09', nbre_de_place_dispo: 110, tarif: 320, ville_arrive: 'Lisbon', ville_depart: 'San Diego', aeroport_id: 30 }
  ];

}
