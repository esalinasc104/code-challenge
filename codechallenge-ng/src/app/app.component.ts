import {Component} from '@angular/core';
import {EmpleadosService} from "./services/EmpleadosService";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent {
  inicio: number=8;
  fin: number=17;
  almuerzo: number=0;
  cant: number=3;
  resulset: [];
  constructor(private empleadoService: EmpleadosService) {
  }

  public onBuscar() {
    this.empleadoService.getAllEmployee(this.inicio, this.fin, this.almuerzo, this.cant).subscribe(data => {
      if (data && data["code"] === "0") {
        this.resulset = data["response"];
      }
    });
  }
}
