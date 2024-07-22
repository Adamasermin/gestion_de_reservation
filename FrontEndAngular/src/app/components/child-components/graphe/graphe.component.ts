import { Component } from '@angular/core';
import { ChartData } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';


@Component({
  selector: 'app-graphe',
  standalone: true,
  imports: [BaseChartDirective],
  templateUrl: './graphe.component.html',
  styleUrl: './graphe.component.css'
})
export class GrapheComponent {
  data: ChartData<'line'> = {
    labels: ['Jan', 'fev', 'Mars', 'Avr', 'Mai'],
    datasets: [
      {
        data: [8, 4, 2, 9, 10], label: "Revenus",
        backgroundColor: 'rgba(75, 192, 192, 0.2)',
        borderColor: 'rgba(75, 192, 192, 1)',
        borderWidth: 1,
      }
    ]
  }
  data_1: ChartData<'bar'> = {
    labels: ['Jan', 'fev', 'Mars', 'Avr', 'Mai'],
    datasets: [
      {
        data: [8, 4, 2, 9, 10], label: "Vols",
        backgroundColor: 'rgba(75, 192, 192, 0.2)',
        borderColor: 'rgba(75, 192, 192, 1)',
        borderWidth: 1,
      }
    ]
  }
}

