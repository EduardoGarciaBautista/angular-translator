import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {UsuarioService} from "../../../../core/services/usuario/usuario.service";
import {Usuario} from "../../../../models/Usuario.model";
import {TranslateService} from "@ngx-translate/core";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  idUsuario: number = null;
  usuario: Usuario = null;
  languages: string[] = [];
  languageSelected: string = "";

  constructor(private route: ActivatedRoute,
              private usuarioService: UsuarioService,
              private translateService: TranslateService) {
    /**
     * se obtiene el id del usuario logueado mediante el parammetro
     */
    route.params.subscribe(result => {
      this.idUsuario = result.id;
    })

    this.languages = translateService.getLangs();
    this.languageSelected = translateService.currentLang;
  }

  ngOnInit(): void {
    this.obtenerUsuario();
  }

  obtenerUsuario() {
    this.usuarioService.obtenerUsuarioPorId(this.idUsuario).subscribe((result) => {
      this.usuario = result.usuario;
    }, (error => {
      console.log(error)}));
  }

  establecerIdioma(event: string) {
    this.translateService.use(event);
  }
}
