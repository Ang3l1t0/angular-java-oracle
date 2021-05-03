import { Component, Input, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-criterios',
  templateUrl: './criterios.component.html',
  styleUrls: ['./criterios.component.css']
})
export class CriteriosComponent implements OnInit {

  constructor(public dataService: DataService) {
    this.dataService.criterioSeleccionado = "";
  }

  ngOnInit(): void {
  }

  onClick(segmentacion1) {
    console.log(segmentacion1);
  }
}

