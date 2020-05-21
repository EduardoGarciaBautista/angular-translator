import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {URL_ROOT_SERVICE} from "../../../../environments/environment";
import {LoginResponse} from "../../../models/Login.model";

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  readonly SERVICE: string = 'consultaUsuario/';

  constructor(private http: HttpClient) { }

  obtenerUsuarioPorId(idUsuario: number) {
    return this.http.get<LoginResponse>(URL_ROOT_SERVICE +  this.SERVICE + idUsuario);
  }
}
