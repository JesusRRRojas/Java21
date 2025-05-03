import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IDistrito } from '../interfaces/idistrito';
import { environment } from '../../../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class DistritoService {

  url= `${environment.URL_BASE}/api/v1/parametros`
  http=inject(HttpClient);
    
  getByFilter(codigoProvincia :String , filtro : String) : Observable<IDistrito[]>{
    let url_local = `${this.url}/provincias/${codigoProvincia}/distritos?nombre=${filtro}`
    console.log(url_local);
    return this.http.get<IDistrito[]>(url_local);
  }
}