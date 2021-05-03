import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-desplegable-data-credito',
  templateUrl: './desplegable-data-credito.component.html',
  styleUrls: ['./desplegable-data-credito.component.css']
})
export class DesplegableDataCreditoComponent implements OnInit {


  constructor(private dataService: DataService) {

  }

  ngOnInit(): void {
  }

}
