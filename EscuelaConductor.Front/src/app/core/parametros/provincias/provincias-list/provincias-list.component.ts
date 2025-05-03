import { CommonModule } from '@angular/common';
import { AfterViewInit, Component, inject, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatTooltipModule } from '@angular/material/tooltip';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { ProvinciaService } from '../../services/provincia.service';
import { DepartamentoService } from '../../services/departamento.service';
import { MatDialog } from '@angular/material/dialog';
import { IProvincia } from '../../interfaces/iprovincia';
import { DepartamentoDetailsComponent } from '../../departamento/departamento-details/departamento-details.component';
import { ProvinciasDetailsComponent } from '../provincias-details/provincias-details.component';
import { IDepartamento } from '../../interfaces/idepartamento';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-provincias-list',
  imports: [   
    CommonModule, 
    //RouterLink,
    PaginationModule,
    MatTableModule,
    MatPaginatorModule,
    MatInputModule ,
    MatIconModule,
    MatButtonModule,
    MatTooltipModule
  ],
  templateUrl: './provincias-list.component.html',
  styleUrl: './provincias-list.component.css'
})
export class ProvinciasListComponent implements OnInit, AfterViewInit {

  @ViewChild(MatPaginator)
  paginator: MatPaginator = new MatPaginator;

  departamento ?: IDepartamento;

  departamentoService=inject(DepartamentoService);
  provinciaService = inject(ProvinciaService)

  activatedRoute = inject(ActivatedRoute);

  toastr = inject(ToastrService);
  router = inject(Router);
  
  private dialog = inject(MatDialog);

  displayedColumns: string[] = ['nombreDepartamento','codigoProvincia','nombre','accion'];
  dataSource: MatTableDataSource<IProvincia> = new MatTableDataSource<IProvincia>([]);

  CodigoDepartamento : string = ''; 

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }
  ngOnInit(): void {
    this.activatedRoute.params.subscribe((prm) => {
      this.CodigoDepartamento = prm['id'];
      this.getDepartamento(this.CodigoDepartamento);
      this.getAll(this.CodigoDepartamento);
    });
  }
  getDepartamento(codigoDepartamento : string ){
    this.departamentoService.getById(codigoDepartamento).subscribe(
      {
        next: (res) => {
          console.log(res);
          this.departamento = res;
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

  getAll(codigoDepartamento: string){
    console.log("===== getAll provincias ====")
    this.provinciaService.getByFilter(codigoDepartamento,'').subscribe(
      {
        next: (res) => {
          console.log(res);
          this.dataSource.data = res;  
          this.dataSource.paginator = this.paginator;
        },
        error: (err: any) => {

        },
        complete: () => {

        }
      }
    );

  }

  nuevo() {
    const dialogRef = this.dialog.open(ProvinciasDetailsComponent, {
      width: '800px',
      data: { 
        EsNuevo: true, 
        CodigoDepartamento : '', 
        NombreDepartamento: '' ,
        CodigoProvincia: '',
        NombreProvincia: ''
      }
    });
    dialogRef.afterClosed().subscribe(resultado => {
      this.getAll(this.CodigoDepartamento);
    });
  }

  editarProvincia(provincia: IProvincia) {
    const dialogRef = this.dialog.open(ProvinciasDetailsComponent, {
      width: '800px',
      data: { 
        EsNuevo: false, 
        CodigoDepartamento : this.departamento?.codigoDepartamento , 
        NombreDepartamento : this.departamento?.nombre , 
        CodigoProvincia : provincia.codigoProvincia, 
        NombreProvincia : provincia.nombre 
      }
    });
    
    dialogRef.afterClosed().subscribe(resultado => {
      this.getAll(this.CodigoDepartamento);
    });
  }
}
