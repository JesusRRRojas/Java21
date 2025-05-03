import {AbstractControl, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule,  Validators} from '@angular/forms';
import {IEscuelaConductor} from './../../interfaces/iescuela-conductor';
import { ChangeDetectionStrategy, Component, inject, OnInit } from '@angular/core';
import { EscuelaConductorService } from '../../services/escuela-conductor.service';
import { DepartamentoService } from '../../../parametros/services/departamento.service';
import { IDepartamento } from '../../../parametros/interfaces/idepartamento';
import { CommonModule } from '@angular/common';
import { IProvincia } from '../../../parametros/interfaces/iprovincia';
import { ProvinciaService } from '../../../parametros/services/provincia.service';
import { IDistrito } from '../../../parametros/interfaces/idistrito';
import { DistritoService } from '../../../parametros/services/distrito.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectChange, MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
@Component({
  selector: 'app-escuela-conductor-details',
  imports:[
    CommonModule, 
    ReactiveFormsModule, 
    FormsModule, 
    MatFormFieldModule,  
    MatIconModule, 
    MatInputModule, 
    MatSelectModule,
    MatCardModule,
    MatButtonModule
  ],
  schemas: [],
  templateUrl: './escuela-conductor-details.component.html',
  styleUrl: './escuela-conductor-details.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class EscuelaConductorDetailsComponent implements OnInit {

  escuelaConductor ?: IEscuelaConductor;

  departamentos: IDepartamento[] = [];
  provincias: IProvincia[] = [];
  distritos: IDistrito[] = [];

  idEscuelaConductor : number = 0;

  formBuilder = inject(FormBuilder);
  router = inject(Router);
  activatedRoute = inject(ActivatedRoute);
  
  toastr = inject(ToastrService);

  escuelaService=inject(EscuelaConductorService);
  departamentoService=inject(DepartamentoService);
  provinciaService=inject(ProvinciaService);
  distritoService=inject(DistritoService);


  frmEscuelaDetails !: FormGroup;

  ngOnInit(): void {
    this.createForm();
    this.obtenerDepartamentos('');
    console.log(this.departamentos);
    console.log(this.provincias);
    console.log(this.distritos);

    this.activatedRoute.params.subscribe((prm) => {
      this.idEscuelaConductor = prm['id'];
      if (this.idEscuelaConductor) {
        this.obtenerEscuelaConductorPorId(this.idEscuelaConductor);
      } else {
        this.idEscuelaConductor = 0;
      }});
  }

  


  save()
  {

    if (this.frmEscuelaDetails.invalid) {
      this.frmEscuelaDetails.markAllAsTouched();
      return;
    }

    /*if (!this.frmEscuelaDetails.valid)
    {
      this.toastr.warning("Debe ingresar todos los valores");
      return;
    }*/
      
    console.log("Guardando ....");
    const escuelaConductor : IEscuelaConductor = {
      id : this.idEscuelaConductor,
      codigoDepartamento : this.frmEscuelaDetails.get('departamento')?.value,
      codigoDistrito : this.frmEscuelaDetails.get('distrito')?.value,
      codigoProvincia : this.frmEscuelaDetails.get('provincia')?.value,
      nroRUC :  this.frmEscuelaDetails.get('RUC')?.value,
      nombreEscuela :  this.frmEscuelaDetails.get('nombreEscuela')?.value,
      direccion : this.frmEscuelaDetails.get('direccion')?.value,
      correo:  this.frmEscuelaDetails.get('correo')?.value,
      telefono :  this.frmEscuelaDetails.get('telefono')?.value,
      estado :  this.frmEscuelaDetails.get('estado')?.value,
    }

    if (this.idEscuelaConductor==0)
    {
      this.escuelaService.nuevo(escuelaConductor).subscribe(
        {
          next: (res) => {
            this.toastr.success("Escuela registrado con exito");
            this.router.navigate(['escuelaconductor/list']);
          },
          error: (err: any) => {
            this.toastr.error(err.error);
            console.log(err);
          },
          complete: () => {
  
          }
        }
      );
      return;
    }

    this.escuelaService.editar(this.idEscuelaConductor,escuelaConductor).subscribe(
      {
        next: (res) => {
          this.toastr.success("Se ha modificado los datos.");
          this.router.navigate(['escuelaconductor/list']);
        },
        error: (err: any) => {
          this.toastr.error(err.error);
          console.log(err);
        },
        complete: () => {

        }
      }
    );





  }
  onCancel(){
    this.router.navigate(['escuelaconductor/list']);
  }

  obtenerEscuelaConductorPorId(id : number)
  {
    this.escuelaService.getById(id).subscribe(
      {
        next: (res) => {
          console.log(res);
          this.escuelaConductor = res
          this.obtenerProvincias(this.escuelaConductor.codigoDepartamento)
          this.obtenerDistritos(this.escuelaConductor.codigoProvincia)
          this.fp['departamento'].setValue(res.codigoDepartamento);
          this.fp['provincia'].setValue(res.codigoProvincia);
          this.fp['distrito'].setValue(res.codigoDistrito);
          this.fp['nombreEscuela'].setValue(res.nombreEscuela);
          this.fp['RUC'].setValue(res.nroRUC);
          this.fp['direccion'].setValue(res.direccion);
          this.fp['correo'].setValue(res.correo);
          this.fp['telefono'].setValue(res.telefono);
          this.fp['estado'].setValue(res.estado);
        },
        error: (err: any) => {

        },
        complete: () => {

        }
      }
    );
  }


  obtenerDepartamentos(filtro : String)
  {
    console.log("OBTENER DEPAR");
    this.departamentoService.getByFilter(filtro).subscribe(
      {
        next: (res) => {
          console.log(res);
          this.departamentos = res
        },
        error: (err: any) => {

        },
        complete: () => {

        }
      }
    );
  }

  obtenerProvincias(codigoDepartamento :String ) //, filtro : String)
  {
    console.log("OBTENER PROV");
    if (!codigoDepartamento) {
      return; 
    }
    this.provinciaService.getByFilter(codigoDepartamento, "").subscribe(
      {
        next: (res) => {
          console.log(res);
          this.provincias = res
        },
        error: (err: any) => {

        },
        complete: () => {

        }
      }
    );
  }

  obtenerDistritos(codigoProvincia :String ) //, filtro : String)
  {
    console.log("OBTENER DIST");
    if (!codigoProvincia) {
      return; 
    }
    this.distritoService.getByFilter(codigoProvincia, "").subscribe(
      {
        next: (res) => {
          console.log(res);
          this.distritos = res
        },
        error: (err: any) => {

        },
        complete: () => {

        }
      }
    );
  }

   // Simula la carga de provincias según el departamento seleccionado
   onDepartamentoChangeEvent(event: MatSelectChange): void {
    const value = event.value;
    this.onDepartamentoChange(value);
  }
  
  onDepartamentoChange(codigoDepartamento: string): void {
    console.log('Departamento seleccionado:', codigoDepartamento);
    
    if (!codigoDepartamento)
      {
        this.provincias = [];
      }
      else
      {
        this.obtenerProvincias(codigoDepartamento);
      }
      
  
    // Al cambiar departamento, resetea provincia y distrito
    this.frmEscuelaDetails.patchValue({ provincia: '', distrito: '' });
    this.distritos = [];
  }
 

  // Simula la carga de distritos según la provincia seleccionada
  onProvinciaChangeEvent(event: MatSelectChange): void {
    const value = event.value;
    this.onProvinciaChange(value);
  }
  onProvinciaChange(codigoProvincia: string): void {
    console.log('Provincia seleccionada:', codigoProvincia);
    if (!codigoProvincia)
      {
        this.distritos = [];
      }
      else
      {
        this.obtenerDistritos(codigoProvincia);
      }
    // Al cambiar provincia, resetea distrito
    this.frmEscuelaDetails.patchValue({ distrito: '' });
  }


  createForm() {
    this.frmEscuelaDetails = this.formBuilder.group({
      departamento: ['', Validators.required],
      provincia: ['', Validators.required],
      distrito: ['', Validators.required],
      nombreEscuela: [
        '', 
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(200)
        ]
      ],
      RUC: [
        '', 
        [
          Validators.required,
          Validators.pattern('^[0-9]{11}$')
        ]
      ],
      direccion: [
        '', 
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(200)
        ]
      ],
      correo: [
        '', 
        [
          Validators.required,
          Validators.email,
          Validators.maxLength(100)
        ]
      ],
      telefono: [
        '', 
        [
          Validators.required,
          Validators.pattern('^[0-9]{9}$'),
          Validators.maxLength(9)
        ]
      ],
      estado: ['', Validators.required]
    });
  }
  getControl(campo: string) {
    return this.frmEscuelaDetails.get(campo);
  }
  // Alias del formulario
  get fp(): { [key: string]: AbstractControl } {
    return this.frmEscuelaDetails.controls;
  }

    
}
