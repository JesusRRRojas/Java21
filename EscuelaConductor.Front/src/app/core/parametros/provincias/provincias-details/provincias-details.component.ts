import { Component, inject, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatCardModule} from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { DepartamentoService } from '../../services/departamento.service';
import { IDepartamento } from '../../interfaces/idepartamento';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { ProvinciaService } from '../../services/provincia.service';
import { IProvincia } from '../../interfaces/iprovincia';
@Component({
  selector: 'app-provincias-details',
  imports: [MatDialogModule,MatFormFieldModule,MatInputModule, MatButtonModule, FormsModule,ReactiveFormsModule, MatCardModule],
  templateUrl: './provincias-details.component.html',
  styleUrl: './provincias-details.component.css'
})
export class ProvinciasDetailsComponent  implements OnInit {

  private dialogRef = inject(MatDialogRef<ProvinciasDetailsComponent>);
  public data = inject(MAT_DIALOG_DATA);


  departamentoService=inject(DepartamentoService);
  provinciaService=inject(ProvinciaService);

  public EsNuevo = this.data?.EsNuevo ?? false; 
  public CodigoDepartamento = this.data?.CodigoDepartamento ?? '';
  public NombreDepartamento = this.data?.NombreDepartamento ?? '';
  public CodigoProvincia = this.data?.CodigoProvincia ?? '';
  public NombreProvincia = this.data?.NombreProvincia ?? '';


  frmProvincia !: FormGroup;
  formBuilder = inject(FormBuilder);

  toastr = inject(ToastrService);
  router = inject(Router);

  ngOnInit() : void
  {
    
    this.createForm();
  }

  guardar() {
    if (this.frmProvincia.invalid) {
      this.frmProvincia.markAllAsTouched();
      return;
    }

    console.log("guardando");
    const nuevaProvincia : IProvincia = {
      codigoDepartamento : this.frmProvincia.get('codigoDepartamento')?.value,
      codigoProvincia : this.frmProvincia.get('codigoProvincia')?.value,
      nombre : this.frmProvincia.get('nombre')?.value
    };

    /*this.provinciaService.nuevo(nuevoProvincia).subscribe(
      {
        next: (res) => {
          this.toastr.success("Provincia registrado con exito");
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
    */

  }

  cancelar() {
    this.dialogRef.close();
  }

  createForm() {
    const codigoNombreDepartamento = this.CodigoDepartamento + ' - ' + this.NombreDepartamento;
    this.frmProvincia = this.formBuilder.group({
      codigoDepartamento: [{ value: codigoNombreDepartamento , disabled: true }],
      codigoProvincia: [{ value: this.CodigoProvincia, disabled: !this.EsNuevo }, [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(4)
      ]],
      nombre: [this.NombreProvincia, [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(200)
      ]]
      
    });
  }
  getControl(campo: string) {
    return this.frmProvincia.get(campo);
  }
  

}
