import { AfterViewInit, Component, inject, OnInit, ViewChild } from '@angular/core';
import { EscuelaConductorService } from '../../services/escuela-conductor.service';
import { IEscuelaConductor } from '../../interfaces/iescuela-conductor';
import { PageChangedEvent, PaginationModule } from 'ngx-bootstrap/pagination';
import { Router, RouterLink } from '@angular/router';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';
import { MatTableModule } from '@angular/material/table';
import { MatPaginator,MatPaginatorModule, PageEvent } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import {MatTabsModule} from '@angular/material/tabs';
import {MatDividerModule} from '@angular/material/divider';
import {MatCardModule} from '@angular/material/card';
import {MatSidenavModule} from '@angular/material/sidenav';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectChange, MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { IDepartamento } from '../../../parametros/interfaces/idepartamento';
import { IProvincia } from '../../../parametros/interfaces/iprovincia';
import { IDistrito } from '../../../parametros/interfaces/idistrito';
import { ProvinciaService } from '../../../parametros/services/provincia.service';
import { DepartamentoService } from '../../../parametros/services/departamento.service';
import { DistritoService } from '../../../parametros/services/distrito.service';

@Component({
  selector: 'app-escuela-conductor-list',
  imports: [   
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterLink,
    PaginationModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatTabsModule,
    MatDividerModule,
    MatCardModule,
    MatSidenavModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule ,
    MatIconModule,
    MatButtonModule
  ],
  templateUrl: './escuela-conductor-list.component.html',
  styleUrl: './escuela-conductor-list.component.css'
})
export class EscuelaConductorListComponent implements OnInit, AfterViewInit  {



  escuelas:IEscuelaConductor[]=[];
  
  pagedItems:IEscuelaConductor[]=[];

  // Paging
  itemsPerPage:number=5
  totalItems?:number;
  currentPage:number=1;

  escuelaService=inject(EscuelaConductorService);
  toastr = inject(ToastrService);
  formBuilder= inject(FormBuilder);
  router=inject(Router);
  
  frmEscuelasList !: FormGroup;
  frmUbigeoFiltro !: FormGroup;

  @ViewChild(MatPaginator)
  paginator: MatPaginator = new MatPaginator;

  displayedColumns: string[] = ['id','nombreDepartamento', 'nombreProvincia', 'nombreDistrito', 'nroRUC', 'nombreEscuela', 'direccion', 'correo', 'telefono', 'estado','accion'];
  dataSource: MatTableDataSource<IEscuelaConductor> = new MatTableDataSource<IEscuelaConductor>([]);

  // Para busqueda por filtro
  departamentos: IDepartamento[] = [];
  provincias: IProvincia[] = [];
  distritos: IDistrito[] = [];
  
  departamentoService=inject(DepartamentoService);
  provinciaService=inject(ProvinciaService);
  distritoService=inject(DistritoService);

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {

    /*
    this.frmProductList= this.formBuilder.group({
      name: ''
    });*/
    this.createForm();
    this.getAll();
    this.obtenerDepartamentos('');
  }

  getAll(){

    this.escuelaService.getAll().subscribe(
      {
        next: (res) => {
          //this.escuelas = res
          //this.pagedItems=this.escuelas.slice(0, this.itemsPerPage);
          this.dataSource.data = res;  
          this.dataSource.paginator = this.paginator;
          this.totalItems = this.escuelas.length;
          console.log(this.dataSource.data);
        },
        error: (err: any) => {

        },
        complete: () => {

        }
      }
    );

  }

  findByNombre(nombre:String){

    this.escuelaService.getByNombre(nombre).subscribe(
      {
        next: (res) => {
          //this.escuelas = res
          //this.pagedItems=this.escuelas.slice(0, this.itemsPerPage);
          this.dataSource.data = res;  
          this.dataSource.paginator = this.paginator;
          this.totalItems = this.escuelas.length;
          
        },
        error: (err: any) => {

        },
        complete: () => {

        }
      }
    );

  }
  findByUbigeo(ubigeo:String){

    this.escuelaService.getByUbigeo(ubigeo).subscribe(
      {
        next: (res) => {
          //this.escuelas = res
          //this.pagedItems=this.escuelas.slice(0, this.itemsPerPage);
          this.dataSource.data = this.pagedItems;  
          this.dataSource.paginator = this.paginator;
          this.totalItems = this.escuelas.length;
        },
        error: (err: any) => {

        },
        complete: () => {

        }
      }
    );

  }

  new(): void {
    // Lógica para crear un nuevo registro
    this.router.navigate(['escuelaconductor/details/0'])
  }

  delete(escuela:IEscuelaConductor){
        Swal.fire({
          title: "Alerta",
          text: "Confirma la eliminación de la escuela : "+escuela.nombreEscuela,
          icon: "warning",
          showCancelButton: true,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: "Si",
          cancelButtonText:"No"
        }).then((result) => {
          if (result.isConfirmed) {
            // Servicio
            this.escuelaService.eliminar(escuela.id).subscribe({
              next: (res) => {
    
                  /*
                  Swal.fire({
                    title: "Aviso!",
                    text: res.message,
                    icon: "success"
                  });
                  */
                  this.toastr.success('Exito al eliminar la escuela', 'Aviso');
                  //this.findByNombre('')                
                  //this.products= this.products.filter((p)=> p.id!==product.id);
                },
                error:(err) =>{
                  this.toastr.error('Error al eliminar la escuela', 'Error');
                },
            }
          );
    
          }
        });
  }

  createForm() {
    this.frmEscuelasList = this.formBuilder.group({
      searchType: ['nombre'],  
      searchText: ['']
    });

     this.frmUbigeoFiltro = this.formBuilder.group({
          departamento: [''],
          provincia: [''],
          distrito: ['']
        });
  }


  search(): void {
    const searchType = this.frmEscuelasList.get('searchType')?.value;
    const searchText = this.frmEscuelasList.get('searchText')?.value;

    if (searchType == 'nombre')
    {
      this.findByNombre(searchText);
      return 
    }
    
    if (searchType == 'ubigeo')
    {
      this.findByUbigeo(searchText);
      return;
    }

    this.getAll();
 
  }

  searchUbigeo(): void {

    const depa = (this.frmUbigeoFiltro.get('departamento')?.value) ? this.frmUbigeoFiltro.get('departamento')?.value : 'todos';
    const prov = (this.frmUbigeoFiltro.get('provincia')?.value) ?  this.frmUbigeoFiltro.get('provincia')?.value : 'todos';
    const dist = (this.frmUbigeoFiltro.get('distrito')?.value) ? this.frmUbigeoFiltro.get('distrito')?.value : 'todos';
    console.log("depa:", depa);
    console.log("prov:", prov);
    console.log("dist:", dist);

    this.escuelaService.getByFiltro(depa, prov, dist).subscribe(
      {
        next: (res) => {
          console.log(res);
          this.dataSource.data = res;  
          this.dataSource.paginator = this.paginator;
          this.totalItems = this.escuelas.length;
          
        },
        error: (err: any) => {
          console.error(err);
        },
        complete: () => {

        }
      }
    );

  }
  /*pageChanged(event: PageChangedEvent): void {
    const startItem = (event.page - 1) * this.itemsPerPage; 
    const endItem = event.page * this.itemsPerPage; 
    this.pagedItems = this.escuelas.slice(startItem, endItem);
  }*/
  pageChanged(event: PageEvent) {

    console.log(this.dataSource.data);
    console.log(this.itemsPerPage);
    console.log(this.totalItems);
    console.log(this.currentPage);

    this.itemsPerPage = event.pageSize;
    this.currentPage = event.pageIndex;
    
    const startIndex = this.currentPage * this.itemsPerPage;
    const pagedData = this.escuelas.slice(startIndex, startIndex + this.itemsPerPage);

    //this.dataSource.data = pagedData;  
    //this.dataSource.paginator = this.paginator;
    this.totalItems = this.escuelas.length;

    console.log(this.dataSource.data);

  }

  // Filtro de datos
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
    this.frmUbigeoFiltro.patchValue({ provincia: '', distrito: '' });
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
    this.frmUbigeoFiltro.patchValue({ distrito: '' });
  }

  borrarFiltro(): void {
    this.frmUbigeoFiltro.patchValue({departamento: '', provincia: '', distrito: '' });
  }

}
