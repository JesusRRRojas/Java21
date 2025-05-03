import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { Router, RouterLink } from '@angular/router';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    RouterLink,
    MatSidenavModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Proyecto front';
  autor = 'Jesus Rojas Rupay';
  fecha = obtenerFechaActual();
}

function  obtenerFechaActual(): String
{
    let fechaActual = new Date();
    let dia = fechaActual.getDate().toString().padStart(2, '0');  // Asegura que el día tenga 2 dígitos
    let mes = (fechaActual.getMonth() + 1).toString().padStart(2, '0');  // Los meses empiezan desde 0
    let año = fechaActual.getFullYear();

    return `${dia}/${mes}/${año}`;
}
