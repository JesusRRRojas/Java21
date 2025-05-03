import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment.development';
import { IDepartamento } from '../interfaces/idepartamento';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartamentoService {

  url= `${environment.URL_BASE}/api/v1/parametros`
  http=inject(HttpClient);
    
  getByFilter(filtro : String) : Observable<IDepartamento[]>{
    let url_local = `${this.url}/departamentos?nombre=${filtro}`
    console.log(url_local);
    return this.http.get<IDepartamento[]>(url_local);
  }

  getById(codigoDepartamento : String) : Observable<IDepartamento>{
    let url_local = `${this.url}/departamentos/${codigoDepartamento}`
    console.log(url_local);
    return this.http.get<IDepartamento>(url_local);
  }

  nuevo(departamento: IDepartamento ) : Observable<IDepartamento>{
    let url_local = `${this.url}/departamentos`
    console.log(url_local);
    return this.http.post<IDepartamento>(url_local, departamento);
  }
}
