import { AfterViewInit, Component , inject, OnInit, ViewChild} from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { IDepartamento } from '../../interfaces/idepartamento';
import { MatPaginator,MatPaginatorModule, PageEvent } from '@angular/material/paginator';
import { DepartamentoService } from '../../services/departamento.service';
import { Router, RouterLink } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { CommonModule } from '@angular/common';
import { DepartamentoDetailsComponent } from '../departamento-details/departamento-details.component';
import { MatDialog } from '@angular/material/dialog';
import { MatTooltipModule } from '@angular/material/tooltip';

@Component({
  selector: 'app-departamento-list',
  imports: [   
    CommonModule, 
    RouterLink,
    PaginationModule,
    MatTableModule,
    MatPaginatorModule,
    MatInputModule ,
    MatIconModule,
    MatButtonModule,
    MatTooltipModule
  ],
  templateUrl: './departamento-list.component.html',
  styleUrl: './departamento-list.component.css'
})
export class DepartamentoListComponent implements OnInit, AfterViewInit {

  @ViewChild(MatPaginator)
  paginator: MatPaginator = new MatPaginator;

  departamentoService=inject(DepartamentoService);
  private dialog = inject(MatDialog);

  displayedColumns: string[] = ['codigoDepartamento','nombre','accion'];
  dataSource: MatTableDataSource<IDepartamento> = new MatTableDataSource<IDepartamento>([]);

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }
  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    console.log("===== getAll departamentos ====")
    this.departamentoService.getByFilter("").subscribe(
      {
        next: (res) => {
          console.log(res);
          this.dataSource.data = res;  
          this.dataSource.paginator = this.paginator;
          console.log(this.dataSource.data);
        },
        error: (err: any) => {

        },
        complete: () => {

        }
      }
    );

  }

  nuevo() {
    const dialogRef = this.dialog.open(DepartamentoDetailsComponent, {
      width: '800px',
      data: { EsNuevo: true, CodigoDepartamento : '', NombreDepartamento: '' }
    });
  
    dialogRef.afterClosed().subscribe(resultado => {
      this.getAll();
    });
  }

  editarDepartamento(departamento: IDepartamento) {
    const dialogRef = this.dialog.open(DepartamentoDetailsComponent, {
      width: '800px',
      data: { EsNuevo: false, CodigoDepartamento : departamento.codigoDepartamento , NombreDepartamento: departamento.nombre }
    });
  
    dialogRef.afterClosed().subscribe(resultado => {
      this.getAll();
    });
  }
}
