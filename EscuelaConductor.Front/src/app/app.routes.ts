import { Routes } from '@angular/router';
import { EscuelaConductorListComponent } from './core/escuela-conductores/components/escuela-conductor-list/escuela-conductor-list.component';
import { EscuelaConductorDetailsComponent } from './core/escuela-conductores/components/escuela-conductor-details/escuela-conductor-details.component';
import { DepartamentoDetailsComponent } from './core/parametros/departamento/departamento-details/departamento-details.component';
import { DepartamentoListComponent } from './core/parametros/departamento/departamento-list/departamento-list.component';
import { ProvinciasDetailsComponent } from './core/parametros/provincias/provincias-details/provincias-details.component';
import { ProvinciasListComponent } from './core/parametros/provincias/provincias-list/provincias-list.component';

export const routes: Routes = [

  {
    path:'',
    component: EscuelaConductorListComponent
  },
  {
    path:'escuelaconductor/list',
    component: EscuelaConductorListComponent
  },
  {
    path:'escuelaconductor/details/:id',
    component: EscuelaConductorDetailsComponent
  },
  {
    path:'departamentos/list',
    component: DepartamentoListComponent
  },
  {
    path:'departamentos/details/:id',
    component: DepartamentoDetailsComponent
  },
  {
    path:'provincias/list/:id',
    component: ProvinciasListComponent
  },


];
