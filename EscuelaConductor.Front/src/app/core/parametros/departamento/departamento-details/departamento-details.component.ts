import { Component, inject, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { DepartamentoService } from '../../services/departamento.service';
import { IDepartamento } from '../../interfaces/idepartamento';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-departamento-details',
  imports: [MatDialogModule,MatFormFieldModule,MatInputModule, MatButtonModule, FormsModule,ReactiveFormsModule, MatCardModule],
  templateUrl: './departamento-details.component.html',
  styleUrl: './departamento-details.component.css'
})
export class DepartamentoDetailsComponent implements OnInit {


  private dialogRef = inject(MatDialogRef<DepartamentoDetailsComponent>);
  public data = inject(MAT_DIALOG_DATA);

  departamentoService=inject(DepartamentoService);

  public EsNuevo = this.data?.EsNuevo ?? false;
  public CodigoDepartamento = this.data?.CodigoDepartamento ?? '';
  public NombreDepartamento = this.data?.NombreDepartamento ?? '';
  frmDepartamento !: FormGroup;
  formBuilder = inject(FormBuilder);

  toastr = inject(ToastrService);
  router = inject(Router);

  ngOnInit() : void
  {

    this.createForm();
  }

  guardar() {
    if (this.frmDepartamento.invalid) {
      this.frmDepartamento.markAllAsTouched();
      return;
    }

    console.log("guardando");
    const nuevoDepartamento : IDepartamento = {
      codigoDepartamento : this.frmDepartamento.get('codigo')?.value,
      nombre : this.frmDepartamento.get('nombre')?.value
    };

    this.departamentoService.nuevo(nuevoDepartamento).subscribe(
      {
        next: (res) => {
          this.toastr.success("Departamento registrado con exito");
          this.dialogRef.close();
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

  cancelar() {
    this.dialogRef.close();
  }
  
  createForm() {
    this.frmDepartamento = this.formBuilder.group({
      codigo: [{ value: this.CodigoDepartamento, disabled: !this.EsNuevo }, [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(2)
      ]],
      nombre: [this.NombreDepartamento, [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(200)
      ]]
      
    });
  }
  getControl(campo: string) {
    return this.frmDepartamento.get(campo);
  }
  
}
