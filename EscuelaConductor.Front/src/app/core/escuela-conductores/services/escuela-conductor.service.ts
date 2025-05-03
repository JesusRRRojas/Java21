import { inject, Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IEscuelaConductor } from '../interfaces/iescuela-conductor';

@Injectable({
  providedIn: 'root'
})
export class EscuelaConductorService {

  url= `${environment.URL_BASE}/api/v1/escuelaConductor`
  http=inject(HttpClient);

  getAll() : Observable<IEscuelaConductor[]>{
    let url_local = `${this.url}/getAll`
    return this.http.get<IEscuelaConductor[]>(url_local);
  }

  getById(id: number) : Observable<IEscuelaConductor>{
    let url_local = `${this.url}/${id}`
    return this.http.get<IEscuelaConductor>(url_local);
  }

  getByNombre(nombre: String) : Observable<IEscuelaConductor[]>{
    let url_local = `${this.url}/buscar?nombre=${nombre}`
    return this.http.get<IEscuelaConductor[]>(url_local);
  }

  getByFiltro(departamento: String, provincia : String, distrito: String) : Observable<IEscuelaConductor[]>{
    let url_local = `${this.url}/buscar-filtro/${departamento}/${provincia}/${distrito}`
    return this.http.get<IEscuelaConductor[]>(url_local);
  }

  getByUbigeo(ubigeo: String) : Observable<IEscuelaConductor[]>{
    let url_local = `${this.url}/buscar-ubigeo?nombre=${ubigeo}`
    return this.http.get<IEscuelaConductor[]>(url_local);
  }
  nuevo(escuelaConductor: IEscuelaConductor) {
    const url_local = `${this.url}`;
    return this.http.post<IEscuelaConductor>(url_local, escuelaConductor);
  }
  editar(id:number, escuelaConductor: IEscuelaConductor) {
    const url_local = `${this.url}/${id}`;
    return this.http.put<IEscuelaConductor>(url_local, escuelaConductor);
  }
  eliminar(id:number) {
    const url_local = `${this.url}/${id}`;
    return this.http.delete(url_local);
  }
}
