import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class EmpleadosService {
  private DOMINIO='http://localhost:8080/api';

  constructor(private conexion: HttpClient) {
  }

  getAllEmployee(inicio:any, fin:any, almuerzo:any, cant:any){
    return this.conexion.get(this.DOMINIO+'/employees/schedule/'+inicio+'/'+fin+'/'+almuerzo+'/'+cant);
  }
}
