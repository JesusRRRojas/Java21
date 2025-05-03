import { inject, Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment.development';
import { IProvincia } from '../interfaces/iprovincia';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProvinciaService {

  url2= `${environment.URL_BASE}/api/v1/parametros`
  http=inject(HttpClient);
    
  getByFilter(codigoDepartamento :String, filtro : String) : Observable<IProvincia[]>{
    let url_local2 =`${this.url2}/departamentos/${codigoDepartamento}/provincias?nombre=${filtro}`;
    console.log('url--' + url_local2 + '--');
    return this.http.get<IProvincia[]>(url_local2);
  }
}
