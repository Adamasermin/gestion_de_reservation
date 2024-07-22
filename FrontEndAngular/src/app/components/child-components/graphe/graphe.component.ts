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
  data: ChartData<'bar'> = {
    labels: ['Jan'],
    datasets: [
      {
        data: [10]
      }
    ]
  }
}

